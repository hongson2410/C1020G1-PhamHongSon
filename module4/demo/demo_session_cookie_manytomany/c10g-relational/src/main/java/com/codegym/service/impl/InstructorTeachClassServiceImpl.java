package com.codegym.service.impl;

import com.codegym.entity.InstructorTeachClass;
import com.codegym.repository.InstructorTeachClassRepository;
import com.codegym.service.InstructorTeachClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorTeachClassServiceImpl implements InstructorTeachClassService {

    @Autowired
    private InstructorTeachClassRepository instructorTeachClassRepository;

    @Override
    public void save(InstructorTeachClass instructorTeachClass) {
        this.instructorTeachClassRepository.save(instructorTeachClass);
    }
}
