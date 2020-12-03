package bai4_class_object.bai_tap.fan;

public class Fan {
    static final int SLOW =1;
    static final int MEDIUM =2;
    static final int FAST =3;
    private int speed=SLOW;
    private boolean on=false;
    private double radius=5;
    private String color="blue";

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isOn() {
        return on;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public Fan() {
    }

    public String toString() {
        if (isOn()){
            return getSpeed()+" "+getColor()+" "+getRadius()+" fan is on";
        }else {
            return getSpeed()+" "+getColor()+" "+getRadius()+" fan is off";
        }
    }
}
