import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class RedCar extends Car {

    private BufferedImage redCar;

    public RedCar(int newX, int newY) {
        super(newX, newY);

        width = 245;
        height = 140;
        speed = 12;

        try {
            redCar = ImageIO.read(getClass().getResource("redCar.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void paintCar(Graphics g) {

        g.drawImage(redCar, xCoordinate, yCoordinate, null);
    } // end of paint car method
} // end of red car
