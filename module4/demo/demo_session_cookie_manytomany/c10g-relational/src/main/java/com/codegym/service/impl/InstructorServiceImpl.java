package com.codegym.service.impl;

import com.codegym.entity.Instructor;
import com.codegym.repository.InstructorRepository;
import com.codegym.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorServiceImpl implements InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    @Override
    public Instructor findById(Integer id) {
        return this.instructorRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Instructor instructor) {
        this.instructorRepository.save(instructor);
    }
}
