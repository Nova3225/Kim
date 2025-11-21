package Display.Label;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class PixelLabel extends JLabel {

    public PixelLabel(String text){
        super(text);
        // 使用等宽字体模拟像素效果
        setFont(new Font("Monospaced", Font.BOLD, 20));
        setHorizontalAlignment(JLabel.CENTER);
        setBackground(new Color(139, 69, 19));
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(139, 69, 19), 2), // 棕色边框
                BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
    }

    public PixelLabel(){
        this("");
    }

    public PixelLabel(String text, int x, int y, int width, int height){
        this(text);
        this.setLocation(x, y);
        this.setSize(width, height);
    }


}
