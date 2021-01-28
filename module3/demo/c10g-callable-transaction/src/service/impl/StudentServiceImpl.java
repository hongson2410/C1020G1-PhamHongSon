package service.impl;

import bean.Student;
import repository.StudentRepository;
import repository.impl.StudentRepositoryImpl;
import repository.impl.StudentRepositoryImplOther;
import service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository = new StudentRepositoryImplOther();

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Integer id) {
        return studentRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public String callTransaction() {
        return this.studentRepository.callTransaction();
    }
}
