import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class TrafficLights {

    private BufferedImage redLight, greenLight, yellowLight;

    public TrafficLights() {

        try {
            redLight = ImageIO.read(getClass().getResource("redLight.png"));
            greenLight = ImageIO.read(getClass().getResource("greenLight.png"));
            yellowLight = ImageIO.read(getClass().getResource("yellowLight.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    } // end of constructor

    public void paintLight(Graphics g) {
        g.drawImage(redLight, 950, 20, null);
        g.drawImage(greenLight, 950, 190, null);
        g.drawImage(yellowLight, 950, 370, null);
        g.drawImage(greenLight, 950, 530, null);
        g.drawImage(yellowLight, 950, 700, null);
    } // end of paint method

} // end of traffic lights class

