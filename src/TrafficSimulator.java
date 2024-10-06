import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrafficSimulator implements ActionListener, Runnable {

    JFrame frame;
    Road road;
    JButton start, stop, pause, vehicle;
    Container south, west;
    boolean running = false;

    public TrafficSimulator() {
        frame = new JFrame("Traffic Simulator");
        frame.setSize(1200, 750);
        frame.setLayout(new BorderLayout());
        road = new Road();
        start = new JButton("Start");
        stop = new JButton("Stop");
        pause = new JButton("Pause");
        vehicle = new JButton("Add Car");

        south = new Container();
        west = new Container();

        south.setLayout(new GridLayout(1, 3));
        south.add(start);
        start.addActionListener(this);
        south.add(pause);
        pause.addActionListener(this);
        south.add(stop);
        stop.addActionListener(this);


        west.setLayout(new GridLayout(10, 1));
        west.add(vehicle);
        vehicle.addActionListener(this);


        frame.add(road, BorderLayout.CENTER);
        frame.add(west, BorderLayout.WEST);
        frame.add(south, BorderLayout.SOUTH);
        GreyCar testCar = new GreyCar(10, 10, 4);
        BlueCar testCar2 = new BlueCar(10, 170, 8);
        RedCar testCar3 = new RedCar(10, 330, 6);
        YellowCar testCar4 = new YellowCar(10, 510, 2);
        road.addCar(testCar);
        road.addCar(testCar2);
        road.addCar(testCar3);
        road.addCar(testCar4);
        frame.repaint();

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end of constructor

    public static void main(String[] args) {
        new TrafficSimulator();

    } // end of main

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource().equals(start)) {
            if(running == false) {
                running = true;
                Thread t = new Thread(this);
                t.start();
            }
        }
        if (event.getSource().equals(stop)) {
            running = false;
        }
    } // end of action performed

    @Override
    public void run() {
        while(running == true) {
            road.step();
            frame.repaint();
            try{
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    } // end of run method

} // end of traffic simulator class
