package bai5_access_modifier.bai_tap;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle= new Circle();

        Circle circle1=new Circle(2.0);

        System.out.println(circle.getRadius());
        System.out.println(circle.getArea());
    }
}
