package com.codegym.repositories.contract;

import com.codegym.models.contract.AttachService;
import com.codegym.models.contract.Contract;
import com.codegym.models.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractDetailRepository extends JpaRepository<ContractDetail, Integer> {
    ContractDetail findContractDetailByAttachServiceAndContract(AttachService attachService, Contract contract);
}
