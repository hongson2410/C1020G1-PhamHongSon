package demo.bai12_map_tree;

import java.util.LinkedHashMap;
import java.util.Map;

public class MyLinkedHashMap {
    public static void main(String[] args) {
        Map<Student, String> myMap = new LinkedHashMap<>();
        myMap.put(new Student(5, "Nguyen Van F"), "Top5");
        myMap.put(new Student(1, "Nguyen Van A"), "Top1");
        myMap.put(new Student(2, "Nguyen Van B"), "Top2");
        myMap.put(new Student(3, "Nguyen Van C"), "Top3");
        myMap.put(new Student(4, "Nguyen Van D"), "Top4");


        System.out.println(myMap.size());
        for (Student student : myMap.keySet()) {
            System.out.println(student.toString() + "Value: " + myMap.get(student));
        }
    }
}
