package Game.Display;

import Game.Display.Panel.GamePanel;
import Game.Display.Panel.BlockPanel;
import Game.Display.Panel.UIPanel;

import javax.swing.*;
import java.awt.*;

public class Layers extends JLayeredPane {

    public GamePanel gamePanel;
    public BlockPanel blockPanel;
    public UIPanel uiPanel;

    public Component[] panelComponents;

    public Layers(){

        super();
        this.setLayout(null);
        this.setPreferredSize(new Dimension(Frame.WIDTH, Frame.HEIGHT));


        gamePanel = new GamePanel();
        add(gamePanel,0);

        blockPanel = new BlockPanel();
        add(blockPanel,1);
        blockPanel.refresh();

        uiPanel = new UIPanel();
        add(uiPanel,2);
        uiPanel.refresh();

        panelComponents = this.getComponents();

    }

}
