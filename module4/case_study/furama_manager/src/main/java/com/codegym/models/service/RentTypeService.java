package com.codegym.models.service;

import javax.persistence.*;

@Entity
@Table(name = "rent_type")
public class RentTypeService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rentTypeId;
    @Column(nullable = false)
    private String rentTypeName;
    @Column(nullable = false)
    private Integer rentTypeCost;

    public Integer getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(Integer rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public Integer getRentTypeCost() {
        return rentTypeCost;
    }

    public void setRentTypeCost(Integer rentTypeCost) {
        this.rentTypeCost = rentTypeCost;
    }
}
