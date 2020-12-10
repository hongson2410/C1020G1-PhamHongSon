package demo.review_comparator;

import java.util.Comparator;

public class StudentSortByNameAndAge implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        int a = o1.getName().compareTo(o2.getName());
        if (a == 0) {
            return o1.getAge() - o2.getAge();
        }
        return a;
    }
}
