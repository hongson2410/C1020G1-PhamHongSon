package demo.bai19_solid.open_close_principle.true_design;

import java.awt.*;

//class hình vuông
public class Square implements IShape {
    private Point topLeft;
    private double side;

    public Square() {
    }

    public Square(Point topLeft, double side) {
        this.topLeft = topLeft;
        this.side = side;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return side*side;
    }
}
