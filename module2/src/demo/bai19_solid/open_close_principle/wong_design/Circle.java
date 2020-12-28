package demo.bai19_solid.open_close_principle.wong_design;

import java.awt.*;

//Hình tròn
public class Circle {
    private Point center;
    private double radius;

    public Circle() {
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
