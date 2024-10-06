import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class RedCar extends Car {

    BufferedImage redCar;

    public RedCar(int newX, int newY, int speed) {
        super(newX, newY, speed);

        width = 245;
        height = 140;
        this.speed = speed;

        try {
            redCar = ImageIO.read(getClass().getResource("redCar.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void paintCar(Graphics g) {
        g.drawImage(redCar, x, y, null);
    }
} // end of red car
