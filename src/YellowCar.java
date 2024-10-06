import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class YellowCar extends Car {

    BufferedImage yellowCar;

    public YellowCar(int newX, int newY, int speed) {
        super(newX, newY, speed);

        width = 245;
        height = 140;
        this.speed = speed;

        try {
            yellowCar = ImageIO.read(getClass().getResource("yellowCar.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        public void paintCar(Graphics g) {
            g.drawImage(yellowCar, x, y, null);
        }

} // end of yellow car
