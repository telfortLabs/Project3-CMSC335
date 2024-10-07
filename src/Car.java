import java.awt.*;


public abstract class Car {

    int xCoordinate, yCoordinate;
    int width;
    int height;
    int speed;


    public Car(int newX, int newY) {
        xCoordinate = newX;
        yCoordinate = newY;
        width = 245;
        height = 140;
    }

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

    public void paintCar(Graphics g) {} //end of method to paint car

} // end of Car class
