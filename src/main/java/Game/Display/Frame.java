package Game.Display;

import javax.swing.*;

public class Frame {

    public JFrame frame = new JFrame();

    public GamePanel gamePanel;

    public Frame() {}

    public void init() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Kim");
        frame.setResizable(false);

        gamePanel = new GamePanel();

        frame.add(gamePanel);
        frame.pack();

        gamePanel.gameThread.start();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }



}
