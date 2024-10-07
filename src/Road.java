import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Road extends JPanel implements Runnable {


    final int laneHeight = 160;
    final int roadWidth = 1200;
    ArrayList<Car> cars = new ArrayList<>();
    ArrayList<TrafficLights> trafficLights = new ArrayList<>();
    private int id = 0;


    public Road() {
        super();
    }

    public void addCar(Car car) {
        cars.add(car);
        Thread newCar = new Thread(this);
        newCar.start();
    }

    public void addLight(TrafficLights light) {
        trafficLights.add(light);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.white);
        for (int b = laneHeight; b < laneHeight * 5; b = b + laneHeight){ // which lane
            for (int k = 0; k < getWidth(); k = k + 40) { // which line
                g.fillRect(k, b, 30, 5);
            }
        }

        for (Car car : cars) {
            car.paintCar(g);
        }

        for (TrafficLights trafficLight : trafficLights) {
            trafficLight.paintLight(g);

        }

    } // end of paint component method

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

    public boolean checkCollision(int x, int y, Car v){

        for (Car car : cars) {
            if (y == car.getyCoordinate()) { // if i'm in the same line
                if (!car.equals(v)) { // if i'm not checking myself
                    if (x < car.getxCoordinate() + car.getWidth() &&
                            x + v.getWidth() > car.getxCoordinate()) {
                        return true;
                    }
                }
            }
        }
        return false;
    } // end collision method

    @Override
    public void run() {
        id++;
        System.out.println("Car #"+ id+ " added");
    } // end of run method

} // end of Road class

