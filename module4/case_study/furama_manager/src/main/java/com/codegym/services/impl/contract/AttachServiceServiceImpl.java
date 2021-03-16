package com.codegym.services.impl.contract;

import com.codegym.models.contract.AttachService;
import com.codegym.repositories.contract.AttachServiceRepository;
import com.codegym.services.AttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceServiceImpl implements AttachServiceService {
    @Autowired
    AttachServiceRepository attachServiceRepository;

    @Override
    public List<AttachService> findAllAttachService() {
        return attachServiceRepository.findAll();
    }
}
