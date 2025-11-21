package Display;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class GameImage {

    public BufferedImage image;
    public int width;
    public int height;
    public int x;
    public int y;

    public GameImage(){

    }

    public void setAttributes(String src, int x, int y, int width, int height){
        try{
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(src)));
        } catch (IOException e) {
            image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
            throw new RuntimeException(e);
        } finally {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }
    }
}
