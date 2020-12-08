package bai7_abstractclass_interface.bai_tap.resideable;

public class SquareTest {
    public static void main(String[] args) {
        Square square = new Square();
        System.out.println(square.getPerimeter());
        square.reside(50);
        System.out.println("Before reside");
        System.out.println(square.getPerimeter());
        System.out.println();

        square = new Square(2.3);
        System.out.println(square.getPerimeter());
        square.reside(50);
        System.out.println("Before reside");
        System.out.println(square.getPerimeter());
        System.out.println();

        square = new Square(5.8, "yellow", true);
        System.out.println(square.getPerimeter());
        square.reside(50);
        System.out.println("Before reside");
        System.out.println(square.getPerimeter());
        System.out.println();
    }
}
