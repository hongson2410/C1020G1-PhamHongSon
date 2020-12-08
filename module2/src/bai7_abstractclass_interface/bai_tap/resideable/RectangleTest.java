package bai7_abstractclass_interface.bai_tap.resideable;

public class RectangleTest {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle.getPerimeter());
        System.out.println("Before reside");
        rectangle.reside(50);
        System.out.println(rectangle.getPerimeter());
        System.out.println();

        rectangle = new Rectangle(2.3, 5.8);
        System.out.println(rectangle.getPerimeter());
        System.out.println("Before reside");
        rectangle.reside(50);
        System.out.println(rectangle.getPerimeter());
        System.out.println();

        rectangle = new Rectangle(2.5, 3.8, "orange", true);
        System.out.println(rectangle.getPerimeter());
        System.out.println("Before reside");
        rectangle.reside(50);
        System.out.println(rectangle.getPerimeter());
    }
}
