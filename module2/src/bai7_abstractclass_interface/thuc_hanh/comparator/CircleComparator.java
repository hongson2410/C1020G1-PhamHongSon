package bai7_abstractclass_interface.thuc_hanh.comparator;

import java.util.Comparator;

public class CircleComparator implements Comparator<Circle> {

    public CircleComparator() {
    }

    @Override
    public int compare(Circle c1, Circle c2) {
        return (int) ((int) c1.getRadius()-c2.getRadius());
    }
}
