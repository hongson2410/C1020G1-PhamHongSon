package bai6_inheritance.bai_tap.point_moveablePoint;

import java.util.Arrays;

public class Point {
    private float x=0;
    private float y=0;

    public Point() {
    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y){
        this.x=x;
        this.y=y;
    }

    private float [] getXY(){
        return new float[]{getX(),getY()};
    }

    @Override
    public String toString(){
        return "Array is: "
                + Arrays.toString(getXY());
    }
}
