package Display;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Panel extends JPanel {

    int width;
    int height;

    public List<GameImage> gameImages = new ArrayList<>();

    public BufferedImage backgroundImage;

    public Panel(){
        super();
    }

    public Panel(int width, int height){
        super();
        setLayout( null);
        setPreferredSize(new Dimension(width, height));
        this.width = width;
        this.height = height;

        setBackgroundImage("/Background/Background2.png");
    }

    public void setBackgroundImage(String src){
        try{
            backgroundImage = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(src)));
        } catch (IOException e) {
            backgroundImage = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        g2.drawImage(backgroundImage, 0, 0, width, height, this);

        //Layer 1
        for (GameImage gameImage : gameImages){
            g2.drawImage(gameImage.image, gameImage.x, gameImage.y, gameImage.width, gameImage.height, this);
        }

    }

}
