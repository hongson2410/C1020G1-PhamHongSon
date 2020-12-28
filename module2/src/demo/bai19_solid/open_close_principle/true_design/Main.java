package demo.bai19_solid.open_close_principle.true_design;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<IShape> iShapes = new ArrayList<>();
        iShapes.add(new Square(new Point(10, 20), 100));
        iShapes.add(new Circle(new Point(10, 20), 10));
        iShapes.add(new Rectangle(new Point(20, 30), 100, 200));
        for (IShape iShape : iShapes){
            System.out.println(iShape.area());
        }
    }
}
