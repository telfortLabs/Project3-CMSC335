import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Road extends JPanel implements Runnable {


    final int laneHeight = 160;
    final int roadWidth = 1200;
    ArrayList<Car> cars = new ArrayList<Car>();
    private int id = 0;

    public Road() {
        super();
    }

    public void addCar(Car car) {
        cars.add(car);
        Thread newCar = new Thread(this);
        newCar.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.white);
        for (int b = laneHeight; b < laneHeight * 4; b = b + laneHeight){ // which lane
            for (int k = 0; k < getWidth(); k = k + 40) { // which line
                g.fillRect(k, b, 30, 5);
            }
        }

        for (int a = 0; a < cars.size(); a++) {
            cars.get(a).paintCar(g);
        }

    } // end of paint component method

    public void step() {
        for (int d = 0; d < cars.size(); d++) {
            Car v = cars.get(d);
            v.setX(v.getX() + v.getSpeed());
            if(v.getX() > roadWidth) {
                v.setX(0);
            }
        }
    } // end of step method

    @Override
    public void run() {
        id++;
        System.out.println("Car #"+ id+ " added");
    } // end of run method

} // end of Road class

