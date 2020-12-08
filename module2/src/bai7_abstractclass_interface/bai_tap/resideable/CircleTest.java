package bai7_abstractclass_interface.bai_tap.resideable;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle.getPerimeter());
        circle.reside(10);
        System.out.println("Before reside");
        System.out.println(circle.getPerimeter());
        System.out.println();

        circle = new Circle(3.5);
        System.out.println(circle.getPerimeter());
        System.out.println("Before reside");
        circle.reside(10);
        System.out.println(circle.getPerimeter());
        System.out.println();

        circle = new Circle(3.5, "indigo", false);
        System.out.println(circle.getPerimeter());
        System.out.println("Before reside");
        circle.reside(50);
        System.out.println(circle.getPerimeter());
    }
}
