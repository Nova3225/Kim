package Game.Display;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
( update() )
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
        */

public class KeyHandler implements KeyListener{

    public boolean wPressed;
    public boolean sPressed;
    public boolean aPressed;
    public boolean dPressed;

    public boolean nearTwoDirection = false;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W){
            wPressed = true;
            if(aPressed ^ dPressed && !sPressed){
                nearTwoDirection = true;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_S){
            sPressed = true;
            if(aPressed ^ dPressed && !wPressed){
                nearTwoDirection = true;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_A){
            aPressed = true;
            if(wPressed ^ sPressed && !dPressed){
                nearTwoDirection = true;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_D){
            dPressed = true;
            if(wPressed ^ sPressed && !aPressed){
                nearTwoDirection = true;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W){
            wPressed = false;
            if(aPressed ^ dPressed && !sPressed){
                nearTwoDirection = false;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_S){
            sPressed = false;
            if(aPressed ^ dPressed && !wPressed){
                nearTwoDirection = false;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_A){
            aPressed = false;
            if(wPressed ^ sPressed && !dPressed){
                nearTwoDirection = false;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_D){
            dPressed = false;
            if(wPressed ^ sPressed && !aPressed){
                nearTwoDirection = false;
            }
        }
    }
}
