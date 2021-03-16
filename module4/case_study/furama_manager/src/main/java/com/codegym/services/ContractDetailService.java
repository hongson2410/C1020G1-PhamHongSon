package com.codegym.services;

import com.codegym.models.contract.ContractDetail;

import java.util.List;

public interface ContractDetailService {
    List<ContractDetail> findAllContractDetail();

    void saveContractDetail(ContractDetail contractDetail);
}
