package com.codegym.service.impl;

import com.codegym.entity.ClassCodeGym;
import com.codegym.repository.ClassCodeGymRepository;
import com.codegym.service.ClassCodeGymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassCodeGymServiceImpl implements ClassCodeGymService {

    @Autowired
    private ClassCodeGymRepository classCodeGymRepository;

    @Override
    public ClassCodeGym findById(Integer id) {
        return this.classCodeGymRepository.findById(id).orElse(null);
    }
}
