package com.codegym.services.impl;

import com.codegym.models.employee.Education;
import com.codegym.repositories.EducationRepository;
import com.codegym.services.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationServiceImpl implements EducationService {
    @Autowired
    EducationRepository educationRepository;

    @Override
    public List<Education> findAllEducation() {
        return educationRepository.findAll();
    }
}
