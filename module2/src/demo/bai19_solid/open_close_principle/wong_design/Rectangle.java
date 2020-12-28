package demo.bai19_solid.open_close_principle.wong_design;

import java.awt.*;

//Hình chữ nhật
public class Rectangle {
    private Point topLeft;
    private double height;
    private double width;

    public Rectangle() {
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
