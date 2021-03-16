package com.codegym.models.employee;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;

    @Column(nullable = false)
    private String employeeName;
    @Column(nullable = false, columnDefinition = "date")
    private String employeeBirthDay;
    @Column(nullable = false)
    private String employeeGender;
    @Column(nullable = false)
    private String employeeIdCard;
    @Column(nullable = false)
    private Double employeeSalary;
    @Column(nullable = false)
    private String employeePhone;
    @Column(unique = true)
    private String employeeEmail;

    private String employeeAddress;


    @ManyToOne
    @JoinColumn(name = "education_id" , referencedColumnName = "educationId")
    private Education education;

    @ManyToOne
    @JoinColumn(name = "division_id" , referencedColumnName = "divisionId")
    private Division division;

    @ManyToOne
    @JoinColumn(name = "position_id" , referencedColumnName = "positionId")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "user_name" , referencedColumnName = "userName")
    private FuramaUser furamaUser;

    public Employee() {
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthDay() {
        return employeeBirthDay;
    }

    public void setEmployeeBirthDay(String employeeBirthDay) {
        this.employeeBirthDay = employeeBirthDay;
    }

    public String getEmployeeGender() {
        return employeeGender;
    }

    public void setEmployeeGender(String employeeGender) {
        this.employeeGender = employeeGender;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public Double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public FuramaUser getFuramaUser() {
        return furamaUser;
    }

    public void setFuramaUser(FuramaUser furamaUser) {
        this.furamaUser = furamaUser;
    }
}
