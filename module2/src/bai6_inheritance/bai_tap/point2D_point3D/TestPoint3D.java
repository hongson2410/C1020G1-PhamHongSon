package bai6_inheritance.bai_tap.point2D_point3D;

public class TestPoint3D {
    public static void main(String[] args) {
        Point3D point= new Point3D();
        point.setXYZ(4,5,6);
        point.setZ(10);
        System.out.println(point.toString());

        Point3D point2= new Point3D(2,3,4);
        System.out.println(point2.toString());
    }
}
