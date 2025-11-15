package Game.Display.Component;

import Game.Display.Panel.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public abstract class ComponentD {

    protected String name;

    protected int x;
    protected int y;

    protected int width;

    protected int height;

    public BufferedImage image;

    public ComponentD(String name){
        this.name = name;
    }

    public ComponentD importImage(String src){
        try {
            image = ImageIO.read(getClass().getResourceAsStream(src));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    public void setAttribute(int x, int y, int width, int height){
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
    }

    public void update(){}

    public void draw(Graphics2D g2){
        g2.drawImage(image, x, y, width, height, null);
    }

    public String getName() {
        return name;
    }

    //Beans
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        x = Math.min(x, GamePanel.WIDTH);
        this.x = Math.max(x, 0);
    }

    public void setY(int y){
        y = Math.min(y, GamePanel.HEIGHT);
        this.y = Math.max(y, 0);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


}
