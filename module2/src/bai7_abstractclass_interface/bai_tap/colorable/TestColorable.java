package bai7_abstractclass_interface.bai_tap.colorable;

public class TestColorable {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(3);
        shapes[1] = new Rectangle(3, 5);
        shapes[2] = new Square(3);
        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                System.out.println(((Circle) shape).getArea());
            } else if (shape instanceof Square) {
                System.out.print(((Square) shape).getArea());
                ((Square) shape).howToColor();
            } else {
                System.out.println(((Rectangle) shape).getArea());
            }
        }
    }
}
