package com.codegym.services.impl;

import com.codegym.models.employee.Division;
import com.codegym.repositories.DivisionRepository;
import com.codegym.services.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionServiceImpl implements DivisionService {
    @Autowired
    DivisionRepository divisionRepository;

    @Override
    public List<Division> findAllDivision() {
        return divisionRepository.findAll();
    }
}
