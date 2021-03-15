package com.codegym.services.impl;

import com.codegym.models.service.TypeService;
import com.codegym.repositories.TypeServiceRepository;
import com.codegym.services.TypeServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeServiceService {
    @Autowired
    TypeServiceRepository typeServiceRepository;

    @Override
    public List<TypeService> findAllTypeService() {
        return typeServiceRepository.findAll();
    }
}
