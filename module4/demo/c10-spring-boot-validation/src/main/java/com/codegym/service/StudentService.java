package com.codegym.service;

import com.codegym.entity.Student;

import java.util.List;

public interface StudentService {

    void save(Student student);

    List<Student> getListOrderBy();
}
