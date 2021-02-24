package com.codegym.service.impl;

import com.codegym.entity.Student;
import com.codegym.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImplOther implements StudentService {
    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public Student findById(Integer id) {
        return null;
    }
}
