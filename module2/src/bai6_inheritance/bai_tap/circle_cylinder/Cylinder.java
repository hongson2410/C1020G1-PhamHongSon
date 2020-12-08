package bai6_inheritance.bai_tap.circle_cylinder;

public class Cylinder extends Circle {
    private double height=0;

    public Cylinder() {
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume(){
        return getArea()*getHeight();
    }

    @Override
    public String toString() {
        return "A cylinder with height= "
                +getHeight()+
                " with "
                +super.toString()+
                ", Volume = "
                +getVolume();
    }
}
