package Game.Display.Entity;

import Game.Display.GamePanel;
import Game.Display.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class PlayerCharacter extends Character{

    GamePanel gp;
    KeyHandler kh;

    public PlayerCharacter(GamePanel gp, KeyHandler kh){
        this.gp = gp;
        this.kh = kh;

        init();
        importPlayerImage();
    }

    private void init(){
        x = 100;
        y = 100;
        width = 16*6;
        height = 16*6;
    }

    private void importPlayerImage(){
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Player/PlayerKim.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(){
        int finalSpeed = speed;
        if (kh.nearTwoDirection){
            finalSpeed = (int)(speed*0.7);
        }
        if (kh.aPressed){
            x -= finalSpeed;
            System.out.println("a");
        }
        if (kh.dPressed){
            x += finalSpeed;
            System.out.println("d");
        }
        if (kh.wPressed){
            y -= finalSpeed;
            System.out.println("w");
        }
        if (kh.sPressed){
            y += finalSpeed;
            System.out.println("s");
        }
    }

    // 绘制 在JPanel中使用
    public void draw(Graphics2D g2){
        g2.drawImage(image, x,y, width, height, null);
    }

}
