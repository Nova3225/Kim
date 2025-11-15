package Game.Display.Panel;

import Game.Display.Component.GameComponent;
import Game.Display.Component.ComponentD;
import Game.Display.Frame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class Panel extends JPanel {

    public final static int WIDTH = Frame.WIDTH;
    public final static int HEIGHT = Frame.HEIGHT;

    ArrayList<ComponentD> components = new ArrayList<>();

    public Panel(){
        this.init();
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBounds(0,0,WIDTH,HEIGHT);
        this.setOpaque(false);
        this.setDoubleBuffered(true);
    }

    //初始化方法：

    protected abstract void importPhotos();

    public abstract void fightingArrangement();

    public void init (){
        ComponentD component;
        for (int i = 0; i < components.size(); i++) {
            component = components.get(i);
            component.setAttribute(0, 0, 0, 0);
            components.set(i, component);
        }
    }

    //刷新方法：

    public void refresh(){
        update();
        repaint();
    }

    protected void update(){
        for (ComponentD character : components){
            character.update();
        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (ComponentD character : components){
            character.draw(g2);
        }
        g2.dispose();
    }


    //导入图片和姓名信息，并加入components组件池 TODO:解决判断不同的Component导入的问题
    protected void importComponentD(String name, String src){
        components.add((ComponentD) new GameComponent(name).importImage(src));
    }

    //工具方法：

    public ComponentD find(String name){
        if (findTool(name) != -1){
            return components.get(findTool(name));
        } else{
            return null;
        }
    }

    private int findTool(String name){
        for (int i = 0; i < components.size(); i++) {
            if (components.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }



}
