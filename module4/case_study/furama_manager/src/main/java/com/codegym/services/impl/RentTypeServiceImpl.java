package com.codegym.services.impl;

import com.codegym.models.service.RentTypeService;
import com.codegym.repositories.RentTypeServiceRepository;
import com.codegym.services.RentTypeServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeServiceImpl implements RentTypeServiceService {

    @Autowired
    RentTypeServiceRepository rentTypeServiceRepository;


    @Override
    public List<RentTypeService> findAllRentTypeService() {
        return rentTypeServiceRepository.findAll();
    }
}
