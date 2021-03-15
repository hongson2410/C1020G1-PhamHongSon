package com.codegym.services.impl;

import com.codegym.repositories.ServiceRepository;
import com.codegym.services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public Page<com.codegym.models.service.Service> findAllService(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public void createService(com.codegym.models.service.Service service) {
        serviceRepository.save(service);
    }
}
