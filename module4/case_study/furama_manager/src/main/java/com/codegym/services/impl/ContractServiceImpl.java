package com.codegym.services.impl;

import com.codegym.models.contract.Contract;
import com.codegym.repositories.ContractRepository;
import com.codegym.services.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    ContractRepository repository;

    @Override
    public Page<Contract> findAllContract(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void saveContract(Contract contract) {
        repository.save(contract);
    }
}
