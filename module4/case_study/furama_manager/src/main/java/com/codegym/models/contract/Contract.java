package com.codegym.models.contract;

import com.codegym.models.customer.Customer;
import com.codegym.models.employee.Employee;
import com.codegym.models.service.Service;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idContract;

    @Column(nullable = false, columnDefinition = "date")
    @Pattern(regexp = "^([0-9]{4}[-]?((0[13-9]|1[012])[-]?(0[1-9]|[12][0-9]|30)|(0[13578]|1[02])[-]?31|02[-]?(0[1-9]|1[0-9]|2[0-8]))|([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468][048])00)[-]?02[-]?29)$", message = "format DD/MM/YYYY")
    private String startDateContract;

    @Column(nullable = false, columnDefinition = "date")
    @Pattern(regexp = "^([0-9]{4}[-]?((0[13-9]|1[012])[-]?(0[1-9]|[12][0-9]|30)|(0[13578]|1[02])[-]?31|02[-]?(0[1-9]|1[0-9]|2[0-8]))|([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468][048])00)[-]?02[-]?29)$", message = "format DD/MM/YYYY")
    private String endDateContract;

    @Column(nullable = false, columnDefinition = "double")
    @Pattern(regexp = "([1-9]+\\d*[.]?\\d*)", message = "input double and > 1")
    private String deposit;

    @Column(nullable = false, columnDefinition = "double")
    @Pattern(regexp = "([1-9]+\\d*[.]?\\d*)", message = "input double and > 1")
    private String total;

    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "customerId")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "employee_id",referencedColumnName = "employeeId")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "service_id",referencedColumnName = "serviceId")
    private Service service;

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    private List<ContractDetail> contractDetails;

    public Contract() {

    }

    public List<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(List<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }

    public Integer getIdContract() {
        return idContract;
    }

    public String getStartDateContract() {
        return startDateContract;
    }

    public void setStartDateContract(String startDateContract) {
        this.startDateContract = startDateContract;
    }

    public String getEndDateContract() {
        return endDateContract;
    }

    public void setEndDateContract(String endDateContract) {
        this.endDateContract = endDateContract;
    }

    public String getDeposit() {
        return deposit;
    }

    public String getTotal() {
        return total;
    }

    public void setIdContract(Integer idContract) {
        this.idContract = idContract;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
