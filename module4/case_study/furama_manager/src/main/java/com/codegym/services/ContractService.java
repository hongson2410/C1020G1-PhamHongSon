package com.codegym.services;

import com.codegym.models.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContractService {
    Page<Contract> findAllContract(Pageable pageable);

    void saveContract(Contract contract);

    Page<Contract> findAllContractUsing(String time, Pageable pageable);

    List<Contract> findContractUsingByCodeCustomer(String time, String code);
}
