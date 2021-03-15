package com.codegym.models.contract;

import javax.persistence.*;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contractDetailId;
    @Column(nullable = false)
    private Integer contractDetailCost;

    @ManyToOne
    @JoinColumn(name = "attach_service_id",referencedColumnName = "idAttachService")
    private AttachService attachService;

    @ManyToOne
    @JoinColumn(name = "contract_id",referencedColumnName = "idContract")
    private Contract contract;

    public Integer getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(Integer contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public Integer getContractDetailCost() {
        return contractDetailCost;
    }

    public void setContractDetailCost(Integer contractDetailCost) {
        this.contractDetailCost = contractDetailCost;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }
}
