package com.codegym.repositories.contract;

import com.codegym.models.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {
    Page<Contract> findAllByStartDateContractBeforeAndEndDateContractAfter(String startDateContract,
            String endDateContract, Pageable pageable);

    List<Contract>
    findAllByStartDateContractBeforeAndEndDateContractAfterAndCustomer_CustomerCodeContaining(String startDateContract,
                                                                                    String endDateContract,
                                                                                    String customer_customerCode);
}
