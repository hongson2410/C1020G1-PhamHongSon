package bai7_abstractclass_interface.thuc_hanh.comparable;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle.toString());

        circle = new Circle(3.5);
        System.out.println(circle.toString());

        circle = new Circle(3.5, "indigo", false);
        System.out.println(circle.toString());
    }
}
