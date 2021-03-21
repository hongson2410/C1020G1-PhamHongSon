package com.codegym.models.contract;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contractDetailId;

    @Column(nullable = false, columnDefinition = "int")
    @Pattern(regexp = "([1-9]+\\d*)", message = "input number and > 0")
    private String quantity;

    @ManyToOne
    @JoinColumn(name = "attach_service_id",referencedColumnName = "idAttachService")
    @NotNull(message = "not NULL")
    private AttachService attachService;

    @ManyToOne
    @JoinColumn(name = "contract_id",referencedColumnName = "idContract")
    @NotNull(message = "not NULL")
    private Contract contract;

    public ContractDetail() {
    }

    public Integer getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(Integer contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
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
