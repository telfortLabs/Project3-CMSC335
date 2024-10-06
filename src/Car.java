import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;


public abstract class Car {

    int x, y;
    int width;
    int height;
    int speed;


    public Car(int newX, int newY, int speed) {
        x = newX;
        y = newY;
        width = 245;
        height = 140;
        this.speed = speed;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void paintCar(Graphics g) {} //end of method to paint car

} // end of Car class
