package com.codegym.services.impl.contract;

import com.codegym.models.contract.Contract;
import com.codegym.repositories.contract.ContractRepository;
import com.codegym.services.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public Page<Contract> findAllContractUsing(String time, Pageable pageable) {
        return repository.findAllByStartDateContractBeforeAndEndDateContractAfter(time,time,pageable);
    }

    @Override
    public List<Contract> findContractUsingByCodeCustomer(String time, String code) {
        return repository.findAllByStartDateContractBeforeAndEndDateContractAfterAndCustomer_CustomerCode(time,time,code);
    }
}
