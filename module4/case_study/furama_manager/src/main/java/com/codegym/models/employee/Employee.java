package com.codegym.models.employee;

import com.codegym.models.contract.Contract;
import com.codegym.validate.DupEmail;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;

    @Column(nullable = false)
    @Pattern(regexp = "[\\D]+",message = "Must not contain numbers ")
    private String employeeName;

    @Column(nullable = false, columnDefinition = "date")
    @Pattern(regexp = "^([0-9]{4}[-]?((0[13-9]|1[012])[-]?(0[1-9]|[12][0-9]|30)|(0[13578]|1[02])[-]?31|02[-]?(0[1-9]|1[0-9]|2[0-8]))|([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468][048])00)[-]?02[-]?29)$", message = "format DD/MM/YYYY")
    private String employeeBirthDay;

    @Column(nullable = false)
    @NotBlank(message = "Must not be left blank")
    @Pattern(regexp = "(Male|Female)",message = "Male or Female")
    private String employeeGender;

    @Column(nullable = false)
    @Pattern(regexp = "^\\d{9}$",message = "Id cart 9 number")
    private String employeeIdCard;

    @Column(columnDefinition = "double")
    @Pattern(regexp = "([1-9]+\\d*[.]?\\d*)", message = "input double and > 1")
    private String employeeSalary;

    @Column(nullable = false)
    @Pattern(regexp = "^(090|091|[(]84[+][)]90|[(]84+[)]91)\\d{7}$",message = "Format 090|091|(84+)")
    private String employeePhone;

    @Column(unique = true, nullable = false)
    @Email(message = "Wrong format")
    @NotBlank(message = "Must not be left blank")
    @DupEmail
    private String employeeEmail;

    @NotBlank(message = "Must not be left blank")
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

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Contract> contracts;

    public Employee() {
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
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

    public String getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(String employeeSalary) {
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
