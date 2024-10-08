import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Project 3
 *
 * @author Telfort
 *
 * @created  2 Oct 2024
 *
 * @summary This class will be used to create
 * the GUi and adds the components to the graphic.
 */

public class TrafficSimulator implements ActionListener, Runnable {

    /*
    Created few variables that will be
    used to create the GUI.
     */

    JFrame frame;
    Road road;
    JButton startSimulation, stopSimulation, blueCar, greyCar, redCar, yellowCar;
    Container south, west, north;
    boolean running = false;

    /**
     * The method below takes all
     * the components and add them
     * to the GUI.
     */

    public void Gui() {
        frame = new JFrame("Traffic Simulator");                                                       // Initialized the frame
        frame.setSize(1200, 900);                                                              // Set the size of the frame
        frame.setLayout(new BorderLayout());                                                                // Set the layout of the frame
        road = new Road();                                                                                  // Initialized road object
        startSimulation = new JButton("Start Simulation");                                             // Initialized simulation button
        stopSimulation = new JButton("Stop Simulation");                                               // Initialized simulation button
        blueCar = new JButton("Add blue car");                                                         // Initialized car button
        greyCar = new JButton("Add grey car");                                                         // Initialized car button
        redCar = new JButton("Add red car");                                                           // Initialized car button
        yellowCar = new JButton("Add yellow car");                                                     // Initialized car button

        south = new Container();                                                                            // Initialized container
        west = new Container();                                                                             // Initialized container
        north = new Container();                                                                            // Initialized container

        south.setLayout(new GridLayout(1, 2));                                                   // Set layout for container
        south.add(startSimulation);                                                                         // Add button to container
        startSimulation.addActionListener(this);                                                         // Add action listener to button
        south.add(stopSimulation);                                                                          // Add button to container
        stopSimulation.addActionListener(this);                                                          // Add action listener to button

        west.setLayout(new GridLayout(4, 1));                                                   // Set layout for container
        west.add(blueCar);                                                                                 // Add button to container
        west.add(greyCar);                                                                                 // Add button to container
        west.add(redCar);                                                                                  // Add button to container
        west.add(yellowCar);                                                                               // Add button to container
        blueCar.addActionListener(this);                                                                // Add action listener to button
        greyCar.addActionListener(this);                                                                // Add action listener to button
        redCar.addActionListener(this);                                                                 // Add action listener to button
        yellowCar.addActionListener(this);                                                              // Add action listener to button

        north.setLayout(new FlowLayout());                                                                 // Set layout for container
        TrafficLights redLight = new TrafficLights();                                                      // Initialized traffic light object
        road.addLight(redLight);                                                                           // Added lights to the road

        frame.add(road, BorderLayout.CENTER);                                                              // Added road object to frame
        frame.add(west, BorderLayout.WEST);                                                                // Added road object to frame
        frame.add(south, BorderLayout.SOUTH);                                                              // Added road object to frame
        frame.add(north, BorderLayout.NORTH);                                                              // Added road object to frame

        frame.repaint();                                                                                   // Repainting the frame
        frame.setVisible(true);                                                                            // Make frame visible
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                                              // Set frame to close when x is clicked
    } // end of GUi method

    /**
     * The method below has one parameter
     * @param event the event to be processed
     * then respond depending on the user's choice.
     * It will start and stop the simulation when
     * the buttons are clicked and
     * add cars to the road when the buttons are clicked.
     */

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource().equals(startSimulation)) {
            if(!running) {
                running = true;
                Thread t = new Thread(this);
                t.start();
            }
        } // end of event listener for start simulation

        if (event.getSource().equals(stopSimulation)) {
            running = false;
        } // end of event listener for stop simulation

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
        } // end of event listener for blue car

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
        } // end of event listener for grey car

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
        } // end of event listener for yellow car

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
        } // end of event listener for red car

    } // end of action performed

    /**
     * This method will move the
     * cars while the simulation
     * is running and catch the errors
     * as they occur.
     */

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
