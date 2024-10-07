import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class YellowCar extends Car {

    private BufferedImage yellowCar;

    public YellowCar (int newX, int newY) {
        super(newX, newY);

        width = 245;
        height = 140;
        speed = 10;

        try {
            yellowCar = ImageIO.read(getClass().getResource("yellowCar.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        public void paintCar(Graphics g) {
            g.drawImage(yellowCar, xCoordinate, yCoordinate, null);
        } // end of paint car method

} // end of yellow car
