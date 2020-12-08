package bai6_inheritance.bai_tap.circle_cylinder;

public class TestCylinder {
    public static void main(String[] args) {
        Cylinder cylinder= new Cylinder();
        System.out.println(cylinder.toString());

        Cylinder cylinder1= new Cylinder(3,"blue",5);
        cylinder1.setHeight(4);
        cylinder1.setRadius(2);
        System.out.println(cylinder1.toString());
    }
}
