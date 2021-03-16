package com.codegym.services;

import com.codegym.models.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContractService {
    Page<Contract> findAllContract(Pageable pageable);

    void saveContract(Contract contract);

    Page<Contract> findAllContractUsing(String time, Pageable pageable);
}
