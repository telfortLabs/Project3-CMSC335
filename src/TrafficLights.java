import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Project 3
 *
 * @author Telfort
 *
 * @created  2 Oct 2024
 *
 * @summary This class will be used to create
 * traffic light objects and add them to the road.
 */

public class TrafficLights {

    private BufferedImage redLight, greenLight, yellowLight;                                                            // variables for red, green and yellow light

    /**
     * The constructor below takes no parameters, and
     * will try to load the images of the lights.
     */

    public TrafficLights() {

        try {
            redLight = ImageIO.read(getClass().getResource("redLight.png"));
            greenLight = ImageIO.read(getClass().getResource("greenLight.png"));
            yellowLight = ImageIO.read(getClass().getResource("yellowLight.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    } // end of constructor

    /**
     * The method below takes one parameter
     * @param g of type graphics then load the
     * images at specific coordinates on the road.
     */

    public void paintLight(Graphics g) {
        g.drawImage(redLight, 950, 20, null);
        g.drawImage(greenLight, 950, 190, null);
        g.drawImage(yellowLight, 950, 370, null);
        g.drawImage(greenLight, 950, 530, null);
        g.drawImage(yellowLight, 950, 700, null);
    } // end of paint method

} // end of traffic lights class

