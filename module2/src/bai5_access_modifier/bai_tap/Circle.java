package bai5_access_modifier.bai_tap;

public class Circle {
    private String color="red";
    static private double radius=1.0;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

     protected double getRadius() {
        return radius;
    }

     protected double getArea(){
        return radius*radius*Math.PI;
    }
}
