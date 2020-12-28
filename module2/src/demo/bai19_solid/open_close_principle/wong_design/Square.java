package demo.bai19_solid.open_close_principle.wong_design;

import java.awt.*;

//class hình vuông
public class Square {
    private Point topLeft;
    private double side;

    public Square() {
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
}
