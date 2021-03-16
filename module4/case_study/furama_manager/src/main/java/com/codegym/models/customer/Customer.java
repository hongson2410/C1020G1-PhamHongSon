package com.codegym.models.customer;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    @Pattern(regexp = "^(KH-)\\d{4}$",message = "Format KH-XXXX")
    @Column(nullable = false)
    private String customerCode;

    @ManyToOne
    @JoinColumn(name = "customer_type_id" , referencedColumnName = "customerTypeId" , nullable = false)
    private CustomerType customerType;

    @Column(nullable = false)
    @NotBlank(message = "Must not be left blank")
    @Pattern(regexp = "\\D",message = "Must not contain numbers ")
    private String customerName;

    @Column(nullable = false, columnDefinition = "date")
    @NotBlank(message = "Must not be left blank")
    private String customerBirthDay;

    @Column(nullable = false)
    @NotBlank(message = "Must not be left blank")
    private String customerGender;

    @Column(nullable = false)
    @Pattern(regexp = "^\\d{9}$",message = "Id cart 9 number")
    private String customerIdCard;

    @Column(nullable = false)
    @Pattern(regexp = "^(090|091|[(]84[+][)]90|[(]84+[)]91)\\d{7}$",message = "Format 090|091|(84+)")
    private String customerPhone;

    @Email(message = "Wrong format")
    @NotBlank(message = "Must not be left blank")
    private String customerEmail;

    @NotBlank(message = "Must not be left blank")
    private String customerAddress;

    public Customer(){

    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthDay() {
        return customerBirthDay;
    }

    public void setCustomerBirthDay(String customerBirthDay) {
        this.customerBirthDay = customerBirthDay;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
}
