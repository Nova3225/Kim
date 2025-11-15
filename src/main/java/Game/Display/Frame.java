package Game.Display;

import javax.swing.*;

public class Frame {

    public final static int WIDTH = 1280;
    public final static int HEIGHT = 720;

    public JFrame frame = new JFrame();

    public Frame() {}

    public Layers layers;

    public void init() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Kim");
        frame.setResizable(false);

        layers = new Layers();
        frame.add(layers);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        layers.gamePanel.gameThread.start();

    }
}
