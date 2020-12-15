package demo.bai12_map_tree;

import java.util.HashMap;
import java.util.Map;

public class MyHashMap {
    public static void main(String[] args) {
        Map<Student, String> myMap = new HashMap<>();
        Student student_a = new Student(1, "Nguyen Van A");
        Student student_a1 = new Student(1, "Nguyen Van A");
        myMap.put(student_a, "Top1");
        myMap.put(student_a1, "Top4");
        System.out.println(myMap.size());
        System.out.println(myMap.get(student_a));
        System.out.println(myMap.get(student_a1));

//        myMap.put(new Student(1, "Nguyen Van A"), "Top1");
//        myMap.put(new Student(2, "Nguyen Van B"), "Top2");
//        myMap.put(new Student(3, "Nguyen Van C"), "Top3");
//        myMap.put(new Student(4, "Nguyen Van D"), "Top4");
//        myMap.put(new Student(5, "Nguyen Van F"), "Top5");
//        myMap.put(null, "Long");
//        myMap.put(null, "Long2");

//        System.out.println(myMap.size());
//        for (Student student : myMap.keySet()) {
//            System.out.println(student.toString() + "Value: " + myMap.get(student));
//        }

//        for(Map.Entry<Student, String> entryStudent: myMap.entrySet()){
//            System.out.println("key: "+entryStudent.getKey() + " value: "+entryStudent.getValue());
//        }
    }
}
