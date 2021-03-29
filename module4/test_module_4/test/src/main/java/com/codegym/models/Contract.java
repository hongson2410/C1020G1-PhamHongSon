package com.codegym.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contractID;

    @Pattern(regexp = "^(MGD-)\\d{4}$", message = "Format MGD-XXXX")
    @Column(unique = true, nullable = false)
    private String contractCode;

    @Column(nullable = false, columnDefinition = "date")
    @Pattern(regexp = "^([0-9]{4}[-]?((0[13-9]|1[012])[-]?(0[1-9]|[12][0-9]|30)|(0[13578]|1[02])[-]?31|02[-]?(0[1-9]|1[0-9]|2[0-8]))|([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468][048])00)[-]?02[-]?29)$", message = "format DD/MM/YYYY")
    private String dateContract;

    @NotNull(message = "Not null")
    private String serviceType;

    @Column(nullable = false, columnDefinition = "double")
    @Pattern(regexp = "([1-9]+\\d*[.]?\\d*)", message = "input double")
    @Min(value = 500000, message = "> 500000(VND)")
    private String cost;

    @Column(nullable = false, columnDefinition = "double")
    @Pattern(regexp = "([1-9]+\\d*[.]?\\d*)", message = "input double")
    @Min(value = 20, message = "> 20 m2")
    private String area;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId")
    @NotNull(message = "Not Null")
    private Customer customer;

    public Contract() {
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public Integer getContractID() {
        return contractID;
    }

    public void setContractID(Integer contractID) {
        this.contractID = contractID;
    }

    public String getDateContract() {
        return dateContract;
    }

    public void setDateContract(String dateContract) {
        this.dateContract = dateContract;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

