package Game.Display;

import Game.Display.Entity.PlayerCharacter;
import Game.Display.Entity.Character;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable{

    // Size
    final static int WIDTH = 1280;
    final static int HEIGHT = 720;
    // Display
    final static int FPS = 60;

    KeyHandler keyHandler = new KeyHandler();
    Thread gameThread = new Thread(this);
    PlayerCharacter playercharacter;
    BufferedImage background;

    ArrayList<Character> characters = new ArrayList<>();

    public GamePanel(){
        //尺寸
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);


        try {
            background = ImageIO.read(getClass().getResourceAsStream("/Background/Background.jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void createPlayer(){
        if (playercharacter == null){
            playercharacter = new PlayerCharacter(this, keyHandler);
            characters.add(playercharacter);
        }else {
            throw new RuntimeException("Player already exists");
        }
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
        for (Character character : characters){
            character.update();
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        //Background
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(background, 0, 0, null);

        //Player
        for (Character character : characters){
            character.draw(g2);
        }

        g2.dispose();
    }


}
