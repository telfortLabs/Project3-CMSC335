import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrafficSimulator implements ActionListener, Runnable {

    JFrame frame;
    Road road;
    JButton startSimulation, stopSimulation, blueCar, greyCar, redCar, yellowCar;
    Container south, west, north;
    boolean running = false;

    public void Gui() {
        frame = new JFrame("Traffic Simulator");
        frame.setSize(1200, 900);
        frame.setLayout(new BorderLayout());
        road = new Road();
        startSimulation = new JButton("Start Simulation");
        stopSimulation = new JButton("Stop Simulation");
        blueCar = new JButton("Add blue car");
        greyCar = new JButton("Add grey car");
        redCar = new JButton("Add red car");
        yellowCar = new JButton("Add yellow car");

        south = new Container();
        west = new Container();
        north = new Container();

        south.setLayout(new GridLayout(1, 2));
        south.add(startSimulation);
        startSimulation.addActionListener(this);
        south.add(stopSimulation);
        stopSimulation.addActionListener(this);


        west.setLayout(new GridLayout(4, 1));
        west.add(blueCar);
        west.add(greyCar);
        west.add(redCar);
        west.add(yellowCar);
        blueCar.addActionListener(this);
        greyCar.addActionListener(this);
        redCar.addActionListener(this);
        yellowCar.addActionListener(this);

        north.setLayout(new FlowLayout());
        TrafficLights redLight = new TrafficLights();
        road.addLight(redLight);

        frame.add(road, BorderLayout.CENTER);
        frame.add(west, BorderLayout.WEST);
        frame.add(south, BorderLayout.SOUTH);
        frame.add(north, BorderLayout.NORTH);

        frame.repaint();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end of constructor

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource().equals(startSimulation)) {
            if(!running) {
                running = true;
                Thread t = new Thread(this);
                t.start();
            }
        }
        if (event.getSource().equals(stopSimulation)) {
            running = false;
        }

        if (event.getSource().equals(blueCar)) {
            BlueCar newCar = new BlueCar(0, 10);
            road.addCar(newCar);
            for (int g = 0; g < road.roadWidth; g = g + 20) {
                for (int k = 10; k < 600; k = k + 160) {
                    newCar.setxCoordinate(g);
                    newCar.setyCoordinate(k);
                    if (!road.checkCollision(g,k, newCar)) {
                        frame.repaint();
                        return;
                    }
                }
            }
        } // end of if method to add car
        if (event.getSource().equals(greyCar)) {
            GreyCar newCar = new GreyCar(0, 10);
            road.addCar(newCar);
            for (int g = 0; g < road.roadWidth; g = g + 20) {
                for (int k = 10; k < 600; k = k + 160) {
                    newCar.setxCoordinate(g);
                    newCar.setyCoordinate(k);
                    if (!road.checkCollision(g,k, newCar)) {
                        frame.repaint();
                        return;
                    }
                }
            }
        } // end of if method to add car
        if (event.getSource().equals(yellowCar)) {
            YellowCar newCar = new YellowCar(0, 10);
            road.addCar(newCar);
            for (int g = 0; g < road.roadWidth; g = g + 20) {
                for (int k = 10; k < 600; k = k + 160) {
                    newCar.setxCoordinate(g);
                    newCar.setyCoordinate(k);
                    if (!road.checkCollision(g,k, newCar)) {
                        frame.repaint();
                        return;
                    }
                }
            }
        } // end of if method to add car
        if (event.getSource().equals(redCar)) {
            RedCar newCar = new RedCar(0, 10);
            road.addCar(newCar);
            for (int g = 0; g < road.roadWidth; g = g + 20) {
                for (int k = 10; k < 600; k = k + 160) {
                    newCar.setxCoordinate(g);
                    newCar.setyCoordinate(k);
                    if (!road.checkCollision(g,k, newCar)) {
                        frame.repaint();
                        return;
                    }
                }
            }
        } // end of if method to add car
    } // end of action performed

    @Override
    public void run() {
        while(running) {
            road.moveCars();
            frame.repaint();
            try{
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    } // end of run method

} // end of traffic simulator class
