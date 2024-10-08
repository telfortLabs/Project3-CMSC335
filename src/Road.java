import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Project 3
 *
 * @author Telfort
 *
 * @created  2 Oct 2024
 *
 * @summary This class will be used to paint a road
 * with 4 lanes then add cars to it and traffic signals.
 */

public class Road extends JPanel implements Runnable {


    private final int laneHeight = 160;                                                                             // Variable for the height of a lane
    final int roadWidth = 1200;                                                                                     // variable for the length of the road
    private ArrayList<Car> cars = new ArrayList<>();                                                                // List to store car objects
    private ArrayList<TrafficLights> trafficLights = new ArrayList<>();                                             // list to hold traffic light objects
    private int id = 0;

    /**
     * Created a constructor that will be used to add
     * cars to the road.
     */

    public Road() {} // end of constructor

    /**
     * The method below takes one parameter
     * @param car then add it to the read and
     * start a new thread for the car created.
     */

    public void addCar(Car car) {
        cars.add(car);
        Thread newCar = new Thread(this);
        newCar.start();
    } // end of add car method

    /**
     * The method below takes one parameter
     * @param light then add the traffic lights
     * to the road.
     */

    public void addLight(TrafficLights light) {
        trafficLights.add(light);
    } // end of add light method

    /**
     * The method below takes one parameter
     * @param g of type Graphic then draw the road,
     * then add the cars to the road, when the user
     * click the button to add a car to the road.
     */

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);                                                        // paint the frame black
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.white);
        for (int b = laneHeight; b < laneHeight * 5; b = b + laneHeight){               // This loop will add 4 white line to the road to create 5 lanes.
            for (int k = 0; k < getWidth(); k = k + 40) {
                g.fillRect(k, b, 30, 5);
            }
        }

        for (Car car : cars) {                                                          // loop to add cars to the road
            car.paintCar(g);
        }

        for (TrafficLights trafficLight : trafficLights) {                              // loops to add traffic lights to the road
            trafficLight.paintLight(g);

        }

    } // end of paint component method

    /**
     * The method below will move the cars
     * on the road, the cars will switch lane
     * if only there is enough space on the
     * left or the right for it to switch, else
     * it will follow slowing behind the car ahead.
     */

    public void moveCars() {
        for (Car v : cars) {
            if (!checkCollision(v.getxCoordinate() + v.getSpeed(), v.getyCoordinate(), v)) {
                v.setxCoordinate(v.getxCoordinate() + v.getSpeed());
                if (v.getxCoordinate() > roadWidth) {
                    if (!checkCollision(0, v.getyCoordinate(), v)) {
                        v.setxCoordinate(0);
                    }
                }
            } else {
                if ((v.getyCoordinate() > 40) && (!checkCollision(v.getxCoordinate(), v.getyCoordinate() - laneHeight, v))) {
                    v.setyCoordinate(v.getyCoordinate() - laneHeight);
                } else if ((v.getyCoordinate() < 40 + 3 * laneHeight) && (!checkCollision(v.getxCoordinate(), v.getyCoordinate() + laneHeight, v))) {
                    v.setyCoordinate(v.getyCoordinate() + laneHeight);
                }
            }
        } // end for loop
    } // end of step method

    /**
     * The method below takes 3 parameters
     * @param x for x coordinate
     * @param y for y coordinate
     * @param v of type Car
     * it will check if the car trailing will collide
     * which the car leading, if yes then
     * @return true.
     */

    public boolean checkCollision(int x, int y, Car v){

        for (Car car : cars) {
            if (y == car.getyCoordinate()) {
                if (!car.equals(v)) {
                    if (x < car.getxCoordinate() + car.getWidth() &&
                            x + v.getWidth() > car.getxCoordinate()) {
                        return true;
                    }
                }
            }
        }
        return false;
    } // end collision method

    /**
     * The run method will print the id
     * of the car created as they are added
     * on the road.
     */

    @Override
    public void run() {
        id++;
        System.out.println("Car #"+ id+ " added");
    } // end of run method

} // end of Road class

