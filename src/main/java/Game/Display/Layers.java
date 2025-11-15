package Game.Display;

import javax.swing.*;
import java.awt.*;

public class Layers extends JLayeredPane {

    public GamePanel gamePanel;
    public UIPanel uiPanel;

    public Layers(){
        super();
        this.setLayout(null);

        this.setPreferredSize(new Dimension(Frame.WIDTH, Frame.HEIGHT));

        gamePanel = new GamePanel();
        add(gamePanel,0);

        uiPanel = new UIPanel();
        add(uiPanel,1);
        uiPanel.refresh();
    }


}
