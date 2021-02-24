package repository;

import model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDao {
    static Map<Integer, Student> listStudent;
    static {
        listStudent = new HashMap<>();
        listStudent.put(1 , new Student(1,"Thinh", "DN"));
        listStudent.put(2 , new Student(2,"Son", "DN"));
        listStudent.put(3 , new Student(3,"Dung", "DN"));
        listStudent.put(4 , new Student(4,"Tung", "DN"));
    }

    public List<Student> getAllStudent(){
        return new ArrayList<>(listStudent.values());
    }

    public void createStudent(Student student){
        listStudent.put(student.getId(), student);
    }

    public Student getStudentById(int id){
        return listStudent.get(id);
    }
}
