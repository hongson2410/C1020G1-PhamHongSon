package services;

import model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent();
    void createStudent(Student student);
    Student getStudentById(int id);
}
