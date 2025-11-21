package Display;

import Display.Label.PixelLabel;
import Game.Action.Battle;
import Game.GameProcess;

import javax.swing.*;
import java.awt.*;

public class Frame {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    public static final int TILE_SIZE = 100;

    public static final Dimension SCREEN_SIZE = new Dimension(WIDTH, HEIGHT);

    JFrame frame = new JFrame();

    public Panel mainPanel;

    public Frame(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        //CHANGEABLE
        frame.setTitle("Kim");
        mainPanel = new Panel(WIDTH,HEIGHT);
        frame.add(mainPanel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void fight(){

        PixelLabel TITLE = new PixelLabel("Kim's Roguelike Adventure DEMO", 2 * TILE_SIZE, TILE_SIZE / 2, 4 * TILE_SIZE, TILE_SIZE / 2);
        mainPanel.add(TITLE);

        JButton attackButton = new JButton("Attack");
        attackButton.setSize(TILE_SIZE, TILE_SIZE / 2);
        attackButton.setLocation(TILE_SIZE + TILE_SIZE / 2, TILE_SIZE * 5);
        attackButton.addActionListener(e -> {
            Battle battle = new Battle();
            battle.playerAttack(GameProcess.map.levelDatas[GameProcess.levelNum].monsters.get(0));
        });
        mainPanel.add(attackButton);

        JButton runeButton = new JButton("Rune");
        runeButton.setSize(TILE_SIZE, TILE_SIZE / 2);
        runeButton.setLocation(TILE_SIZE * 3 + TILE_SIZE / 2, TILE_SIZE * 5);
        runeButton.addActionListener(e -> {
            showInfo();
        });
        mainPanel.add(runeButton);

        JButton defenseButton = new JButton("Defense");
        defenseButton.setSize(TILE_SIZE, TILE_SIZE / 2);
        defenseButton.setLocation(TILE_SIZE * 5 + TILE_SIZE / 2, TILE_SIZE * 5);
        defenseButton.addActionListener(e -> {
            
        });
        mainPanel.add(defenseButton);

        GameImage gameImage = new GameImage();
        gameImage.setAttributes("/Player/PlayerKim.png", TILE_SIZE, TILE_SIZE, TILE_SIZE, TILE_SIZE);
        mainPanel.gameImages.add(gameImage);
        mainPanel.repaint();

    }

    public void showInfo(){
        JFrame infoFrame = new JFrame();
        infoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        infoFrame.setResizable(false);
        infoFrame.setTitle("Kim");
        Panel panel = new Panel(WIDTH,HEIGHT / 2);
        panel.setBackgroundImage("/Background/Background.png");
        infoFrame.add(panel);

        JLabel label = new JLabel("<html>Kim is a roguelike adventure game.<br/>" +
                "You can attack, rune, and defense.<br/>" +
                "You can also use items.<br/>" +
                "You can also use skills.<br/>" +
                "You can also use skills.<br/>" +
                "You can also use skills.<br/>" +
                "You can also use skills.<br/>" +
                "You can also use skills.<br/>"
        );
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        label.setBackground(Color.WHITE);
        label.setOpaque(true);
        label.setSize(WIDTH / 2, HEIGHT / 2);
        label.setLocation(0, 0);
        panel.add( label);

        infoFrame.pack();
        infoFrame.setLocationRelativeTo(null);
        infoFrame.setVisible(true);
    }

    public void init(){
        frame.getContentPane().removeAll();
        frame.revalidate();
        frame.repaint();
    }



}
