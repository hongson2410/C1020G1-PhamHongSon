package com.codegym.services.impl.service;

import com.codegym.repositories.service.ServiceRepository;
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
        Page<com.codegym.models.service.Service> services = serviceRepository.findAll(pageable);
        if (!services.isEmpty()) {
            for (com.codegym.models.service.Service service : services.getContent()) {
                service.setCost(String.valueOf(service.getRentTypeService().getRentTypeCost() * Integer.parseInt(service.getMax_people())));
            }
            return services;
        }
        return services;
    }

    @Override
    public void saveService(com.codegym.models.service.Service service) {
        serviceRepository.save(service);
    }

    @Override
    public com.codegym.models.service.Service findById(String id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteService(String id) {
        serviceRepository.deleteById(id);
    }
}
