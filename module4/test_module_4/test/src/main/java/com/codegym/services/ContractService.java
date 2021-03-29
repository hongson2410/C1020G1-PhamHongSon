package com.codegym.services;

import com.codegym.models.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContractService {
    Page<Contract> findAllContract(Pageable pageable);

    List<Contract> findByServiceTypeContainingOrCustomer_CustomerNameContaining(String name);

    Contract findContractById(Integer id);

    void saveContract(Contract contract);

    void deleteContract(Integer id);
}
