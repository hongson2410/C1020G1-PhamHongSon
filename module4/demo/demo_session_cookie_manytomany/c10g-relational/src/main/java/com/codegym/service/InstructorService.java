package com.codegym.service;

import com.codegym.entity.Instructor;

public interface InstructorService {

    Instructor findById(Integer id);

    void save(Instructor instructor);
}
