import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GreyCar extends Car {

    BufferedImage greyCar;

    public GreyCar(int newX, int newY, int speed) {
        super(newX, newY, speed);

        width = 245;
        height = 140;
        this.speed = speed;

        try {
            greyCar = ImageIO.read(getClass().getResource("greyCar.jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void paintCar(Graphics g) {
        g.drawImage(greyCar, x, y, null);
    } //end of method to paint car

} // end of grey car
