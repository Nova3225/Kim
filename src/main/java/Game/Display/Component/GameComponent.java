package Game.Display.Component;

import Game.Display.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameComponent {

    public BufferedImage image;

    public String name;

    int x;
    int y;

    int width;
    int height;

    public GameComponent(String name){
        this.name = name;
    }

    public GameComponent(int x, int y, int width, int height){
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
    }

    public void setAttribute(int x, int y, int width, int height){
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
    }

    public void update(){

    }

    public void draw(Graphics2D g2){
        g2.drawImage(image, x, y, width, height, null);
    }

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
