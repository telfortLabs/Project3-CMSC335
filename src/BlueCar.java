import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class BlueCar extends Car {

    BufferedImage blueCar;

    public BlueCar(int newX, int newY, int speed) {
        super(newX, newY, speed);

        width = 245;
        height = 140;
        this.speed = speed;

        try {
            blueCar = ImageIO.read(getClass().getResource("blueCar.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void paintCar(Graphics g) {
        g.drawImage(blueCar, x, y, null);
    }

} // end of blue car
