package bai6_inheritance.bai_tap.point_moveablePoint;

public class TestMovablePoint {
    public static void main(String[] args) {
        MovablePoint point = new MovablePoint();
        point.move();
        System.out.println(point.toString());

        point.setXY(3,4);
        point.setSpeed(5,6);
        System.out.println(point.toString());

        point.move();

        System.out.println(point.toString());

        point.move();
        System.out.println(point.toString());
    }
}
