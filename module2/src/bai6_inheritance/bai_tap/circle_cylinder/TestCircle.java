package bai6_inheritance.bai_tap.circle_cylinder;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle=new Circle();
        circle.setRadius(2);
        System.out.println(circle.toString());

        Circle circle1=new Circle(3,"blue");
        circle1.setColor("yellow");
        System.out.println(circle1.toString());
    }
}
