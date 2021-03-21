package com.codegym.services.impl.contract;

import com.codegym.models.contract.ContractDetail;
import com.codegym.repositories.contract.ContractDetailRepository;
import com.codegym.services.ContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailServiceImpl implements ContractDetailService {
    @Autowired
    ContractDetailRepository contractDetailRepository;

    @Override
    public List<ContractDetail> findAllContractDetail() {
        return contractDetailRepository.findAll();
    }

    @Override
    public void saveContractDetail(ContractDetail contractDetail) {
        ContractDetail contractDetail1= contractDetailRepository.findContractDetailByAttachServiceAndContract(
                contractDetail.getAttachService(), contractDetail.getContract());
        if (contractDetail1== null){
            contractDetailRepository.save(contractDetail);
            return;
        }
        contractDetail1.setQuantity(String.valueOf(Integer.parseInt(contractDetail.getQuantity())+Integer.parseInt(contractDetail.getQuantity())));
        contractDetailRepository.save(contractDetail1);
    }
}
