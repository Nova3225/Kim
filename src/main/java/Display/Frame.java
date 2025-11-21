package Display;

import Game.Battle.Battle;
import Game.GameProcess;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageConsumer;
import java.awt.image.ImageProducer;

public class Frame {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    public static final int TILE_SIZE = 100;

    public static final Dimension SCREEN_SIZE = new Dimension(WIDTH, HEIGHT);

    public static final Dimension LABEL_MEDIUM_SIZE = new Dimension(WIDTH / 2, HEIGHT / 16);
    public static final int MEDIUM_LABEL_XPOSITION = WIDTH / 2 - LABEL_MEDIUM_SIZE.width / 2;

    JFrame frame = new JFrame();

    public Panel mainPanel;

    public Frame(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Kim");

        mainPanel = new Panel(WIDTH,HEIGHT);
        mainPanel.setBackground(Color.WHITE);
        frame.add(mainPanel);
        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void start(){

        JLabel label = new JLabel("Kim's Roguelike Adventure DEMO");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        label.setSize(LABEL_MEDIUM_SIZE);
        label.setLocation(MEDIUM_LABEL_XPOSITION, HEIGHT / 16);
        label.setOpaque(true);
        label.setBackground(new Color(255, 255, 255, 200)); // 半透明白色背景
        mainPanel.add(label);

        JButton attackButton = new JButton("Attack");
        attackButton.setSize(TILE_SIZE, TILE_SIZE / 2);
        attackButton.setLocation(TILE_SIZE + TILE_SIZE / 2, TILE_SIZE * 5);
        attackButton.addActionListener(e -> {
            Battle battle = new Battle();
            battle.playerAttack(GameProcess.map.levelDatas[0].monsters.get(0));
        });
        mainPanel.add(attackButton);

        JButton runeButton = new JButton("Rune");
        runeButton.setSize(TILE_SIZE, TILE_SIZE / 2);
        runeButton.setLocation(TILE_SIZE * 3 + TILE_SIZE / 2, TILE_SIZE * 5);
        runeButton.addActionListener(e -> {
            
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



}
