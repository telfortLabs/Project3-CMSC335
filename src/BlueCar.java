import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class BlueCar extends Car {

    private BufferedImage blueCar;

    public BlueCar(int newX, int newY) {
        super(newX, newY);

        width = 245;
        height = 140;
        speed = 6;

        try {
            blueCar = ImageIO.read(getClass().getResource("blueCar.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // end of constructor

    public void paintCar(Graphics g) {

        g.drawImage(blueCar, xCoordinate, yCoordinate, null);
    } // end of paint car method

} // end of blue car
