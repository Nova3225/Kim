package Game.Display;

import Game.Display.Component.GameComponent;
import Game.Display.Entity.PlayerCharacter;
import Game.Display.Entity.Character;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class GamePanel extends JPanel implements Runnable{

    // Size
    public final static int WIDTH = Frame.WIDTH;
    public final static int HEIGHT = Frame.HEIGHT;
    // Display
    final static int FPS = 60;

    KeyHandler keyHandler = new KeyHandler();
    Thread gameThread = new Thread(this);
    PlayerCharacter playercharacter;

    ArrayList<Character> characters = new ArrayList<>();

    ArrayList<GameButton> buttons = new ArrayList<>();

    public GamePanel(){
        //尺寸
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBounds(0,0,WIDTH,HEIGHT);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
        this.setOpaque(false);

        // 初始化
        fightingArrangement();
    }

    //INIT方法


    public void createPlayerEntity(){
        if (playercharacter == null){
            playercharacter = new PlayerCharacter(this, keyHandler);
        }else {
            throw new RuntimeException("Player already exists");
        }
    }

    public void deletePlayerEntity(){
        if (characters.indexOf(playercharacter) != -1){
            characters.remove(playercharacter);
        }else {
            throw new RuntimeException("Player doesn't exist");
        }
    }

    public void fightingArrangement(){
        createPlayerEntity();
        playercharacter.setAttribute(WIDTH / 3 / 3, HEIGHT / 6 / 2, WIDTH / 3 / 3, WIDTH / 3 / 3);
        characters.add(playercharacter);
    }

    @Override
    public void run() {
        //Timer
        //上一次刷新的时刻
        double lastTime = System.nanoTime();
        //每一帧的间隔时间
        final double durationTimePerFrame = (double) 1000000000 / FPS;
        //当前时刻
        double currentTime;
        //现在距离上一帧的时刻是否满一帧的时长
        double total = 0;
        //每秒帧率计数
        double framePerSecondCount = 0;
        //按秒计时
        double timer = 0;

        while (gameThread != null){
            currentTime = System.nanoTime();
            total += (currentTime - lastTime)/durationTimePerFrame;
            timer += currentTime - lastTime;
            lastTime = currentTime;
            if (total >= 1){
                lastTime = System.nanoTime();
                framePerSecondCount += 1;
                total--;
                //刷新与绘图
                update();
                repaint();
            }
            //帧率显示
            if (timer >= 1000000000) {
                System.out.println("FPS:" + framePerSecondCount);
                framePerSecondCount = 0;
                timer = 0;
            }
        }
    }

    private void update() {

        /*
        for (GameComponent component : components){
            component.update();
        }

         */

        for (Character character : characters){
            character.update();
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        //Character
        for (Character character : characters){
            character.draw(g2);
        }
        g2.dispose();
    }
}
