package demo.review_comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList();
        studentList.add(new Student("Nguyen Van A", 18));
        studentList.add(new Student("Nguyen Van A", 8));
        studentList.add(new Student("Nguyen Van E", 118));
        studentList.add(new Student("Nguyen Van E", 1118));
        studentList.add(new Student("Nguyen Van C", 1));

//        Collections.sort(studentList);
        StudentSortByName studentSortByName = new StudentSortByName();
        StudentSortByAge studentSortByAge = new StudentSortByAge();
        StudentSortByNameAndAge studentSortByNameAndAge = new StudentSortByNameAndAge();
        Collections.sort(studentList, studentSortByAge);

        for (Object element : studentList) {
            System.out.println(element);
        }
    }
}
