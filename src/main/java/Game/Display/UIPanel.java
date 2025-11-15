package Game.Display;

import Game.Display.Component.GameComponent;
import Game.Display.Entity.Character;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UIPanel extends JPanel {

    public final static int WIDTH = Frame.WIDTH;
    public final static int HEIGHT = Frame.HEIGHT;

    ArrayList<GameComponent> components = new ArrayList<>();

    public UIPanel(){
        //尺寸
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBounds(0,0,WIDTH,HEIGHT);
        this.setDoubleBuffered(true);

        importPhotos();
        fightingArrangement();
    }

    public void importPhotos(){
        GameComponent background = new GameComponent("Background");
        GameComponent playerDataPanel = new GameComponent("PlayerDataPanel");
        GameComponent monsterDataPanel = new GameComponent("MonsterDataPanel");
        try {
            background.image = ImageIO.read(getClass().getResourceAsStream("/Background/Background.png"));
            components.add(background);
            playerDataPanel.image = ImageIO.read(getClass().getResourceAsStream("/Panels/DataFrame.png"));
            components.add(playerDataPanel);
            monsterDataPanel.image = ImageIO.read(getClass().getResourceAsStream("/Panels/MonsterDataFrame.png"));
            components.add(monsterDataPanel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fightingArrangement () {
        GameComponent component;
        for (int i = 0; i < components.size(); i++) {
            switch (components.get(i).name) {
                case "Background":
                    component = components.get(i);
                    component.setAttribute(0, 0, WIDTH, HEIGHT);
                    components.set(i, component);
                    break;
                case "PlayerDataPanel":
                    component = components.get(i);
                    component.setAttribute(0, 0, WIDTH / 3, HEIGHT);
                    components.set(i, component);
                    break;
                case "MonsterDataPanel":
                    component = components.get(i);
                    component.setAttribute(WIDTH / 3 * 2, 0, WIDTH / 3, HEIGHT);
                    components.set(i, component);
                    break;
            }
        }
    }

    public void refresh(){

        update();
        repaint();

    }

    public void update(){

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        //Character
        for (GameComponent component : components){
            component.draw(g2);
        }
        g2.dispose();
    }
}