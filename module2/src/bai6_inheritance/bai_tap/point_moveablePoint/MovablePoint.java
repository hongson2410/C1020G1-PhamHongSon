package bai6_inheritance.bai_tap.point_moveablePoint;

import java.util.Arrays;

public class MovablePoint extends Point {
    private float xSpeed=0;
    private float ySpeed=0;

    public MovablePoint() {
    }

    public MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed){
        this.xSpeed= xSpeed;
        this.ySpeed= ySpeed;
    }

    public float[] getSpeed(){
        return new float[]{getXSpeed(),getYSpeed()};
    }

    @Override
    public String toString(){
        return super.toString()+
                ", speed is: "+ Arrays.toString(getSpeed());
    }

    public MovablePoint move(){
         setX(getX()+getXSpeed());
         setY(getY()+getYSpeed());
        return this;
    }
}
