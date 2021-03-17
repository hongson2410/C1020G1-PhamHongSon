package com.codegym.services;

import com.codegym.models.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServiceService {
    Page<Service> findAllService(Pageable pageable);

    void saveService(Service service);

    Service findById(String id);

    void deleteService(String id);
}
