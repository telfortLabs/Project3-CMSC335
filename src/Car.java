import java.awt.*;

/**
 * Project 3
 *
 * @author Telfort
 *
 * @created  2 Oct 2024
 *
 * @summary This class is the parent of all Car object
 * and will be used to create a car object.
 */

public abstract class Car {

    int xCoordinate, yCoordinate;                                                                   // Variable for x and y coordinate
    int width;                                                                                      // variable for the width of the car
    int height;                                                                                     // variable for the height of the car
    int speed;                                                                                      // variable for the speed of the car

    /**
     * The constructor below takes 2 parameters
     * @param newX for the x Coordinate of the car
     * @param newY for the y coordinate of the car
     * which will be used to create a car object.
     */

    public Car(int newX, int newY) {
        xCoordinate = newX;
        yCoordinate = newY;
        width = 245;
        height = 140;
    }

    /*
     * Added getters and setters for x coordinate, y coordinate
     * speed and width.
     */

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public int getSpeed() {
        return speed;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public int getWidth() {
        return width;
    }

    /**
     * The method below takes one parameter
     * @param g of type Graphics which
     * will be used to paint the car object.
     */

    public void paintCar(Graphics g) {} //end of method to paint car

} // end of Car class
