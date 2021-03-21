package com.codegym.models.service;

import com.codegym.models.contract.Contract;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
public class Service {
    @Id
    @Pattern(regexp = "^(DV-)\\d{4}$",message = "Format DV-XXXX")
    private String serviceId;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Must not be left blank")
    @Pattern(regexp = "[\\D]+",message = "Must not contain numbers")
    private String nameService;

    private String standard_room;

    @Column(columnDefinition = "double")
    @Pattern(regexp = "([1-9]+\\d*[.]?\\d*)", message = "input double and > 1")
    private String area;

    @Column(columnDefinition = "double")
    @Pattern(regexp = "([1-9]+\\d*[.]?\\d*)", message = "input double and > 1")
    private String pool_area;
    
    @Column(columnDefinition = "int")
    @Pattern(regexp = "([1-9]+\\d*)", message = "input number and > 0")
    private String floor;

    @Column(columnDefinition = "int")
    @Pattern(regexp = "([1-9]+\\d*)", message = "input number and > 0")
    private String max_people;

    @Column(columnDefinition = "int")
    private String cost;
//    @Pattern(regexp = "([1-9]+\\d*)", message = "input number and > 0")


    @ManyToOne
    @JoinColumn(name = "service_type_id", referencedColumnName = "serviceTypeId")
    private TypeService typeService;
    @ManyToOne
    @JoinColumn(name = "service_rent_type_id", referencedColumnName = "rentTypeId")
    private RentTypeService rentTypeService;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private List<Contract> contracts;

    public Service() {
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getStandard_room() {
        return standard_room;
    }

    public void setStandard_room(String standard_room) {
        this.standard_room = standard_room;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPool_area() {
        return pool_area;
    }

    public void setPool_area(String pool_area) {
        this.pool_area = pool_area;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getMax_people() {
        return max_people;
    }

    public void setMax_people(String max_people) {
        this.max_people = max_people;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public TypeService getTypeService() {
        return typeService;
    }

    public void setTypeService(TypeService typeService) {
        this.typeService = typeService;
    }

    public RentTypeService getRentTypeService() {
        return rentTypeService;
    }

    public void setRentTypeService(RentTypeService rentTypeService) {
        this.rentTypeService = rentTypeService;
    }
}
