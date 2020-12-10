package demo.review_comparator;

import java.util.Comparator;

public class StudentSortByAge implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if(o1.getAge() > o2.getAge()){
            return 100;
        } else if (o1.getAge() < o2.getAge()){
            return -1;
        } else {
            return 0;
        }
//        return o1.getAge() - o2.getAge();
    }
}
