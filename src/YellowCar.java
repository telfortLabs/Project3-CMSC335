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
 * @summary This class is a child of the parent class Car
 * and will be used to create a yellow car object.
 */

public class YellowCar extends Car {

    private BufferedImage yellowCar;                                                                                    // variable to store image of car

    /**
     * The constructor below takes 2 parameters
     * @param newX for the x Coordinate of the car
     * @param newY for the y coordinate of the car
     * which will be used to create a car object.
     */

    public YellowCar (int newX, int newY) {
        super(newX, newY);

        width = 245;
        height = 140;
        speed = 10;

        try {
            yellowCar = ImageIO.read(getClass().getResource("yellowCar.png"));                                    // Try load image and catch errors as they occur.
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * The method below takes one parameter
     * @param g of type Graphics which
     * will be used to paint the car object.
     */

    @Override
    public void paintCar(Graphics g) {
        g.drawImage(yellowCar, xCoordinate, yCoordinate, null);
    } // end of paint car method

} // end of yellow car
