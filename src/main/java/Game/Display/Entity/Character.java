package Game.Display.Entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Character {

    public int x;
    public int y;
    public int width;
    public int height;
    public int speed = 5;

    public BufferedImage image;

    public abstract void update();

    public abstract void draw(Graphics2D g2);

}
