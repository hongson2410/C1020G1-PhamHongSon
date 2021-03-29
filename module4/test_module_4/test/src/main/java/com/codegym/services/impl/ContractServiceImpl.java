package com.codegym.services.impl;

import com.codegym.models.Contract;
import com.codegym.repositories.ContractRepository;
import com.codegym.services.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    ContractRepository contractRepository;


    @Override
    public Page<Contract> findAllContract(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public List<Contract> findByServiceTypeContainingOrCustomer_CustomerNameContaining(String name) {
        return contractRepository.findByServiceTypeContaining(name);
    }

    @Override
    public Contract findContractById(Integer id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public void saveContract(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void deleteContract(Integer id) {
        contractRepository.deleteById(id);
    }
}
