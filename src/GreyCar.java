import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GreyCar extends Car {

    private BufferedImage greyCar;

    public GreyCar(int newX, int newY) {
        super(newX, newY);

        width = 245;
        height = 140;
        speed = 4;
        try {
            greyCar = ImageIO.read(getClass().getResource("greyCar.jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void paintCar(Graphics g) {
        g.drawImage(greyCar, xCoordinate, yCoordinate, null);
    } //end of method to paint car

} // end of grey car
