package bai6_inheritance.bai_tap.circle_cylinder;

public class Circle {
    private double radius=0;
    private String color="red";

    public Circle() {
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea (){
        return Math.PI*getRadius()*getRadius();
    }

    @Override
    public String toString(){
        return "A Circle with radius= "
                +getRadius()+
                " with color is "
                +getColor()+
                ", Area is: "
                +getArea();
    }
}
