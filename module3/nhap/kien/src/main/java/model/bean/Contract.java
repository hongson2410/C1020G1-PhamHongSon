package model.bean;

public class Contract {
    Integer idContract;
    String startDateContract;
    String endDateContract;
    double deposit;
    double total;
    String customerID;
    String employeeID;
    String serviceID;

    public Contract(){

    }

    public Contract(String startDateContract, String endDateContract, double deposit, double total,
                    String employeeID, String customerID, String serviceID) {
        this.startDateContract = startDateContract;
        this.endDateContract = endDateContract;
        this.deposit = deposit;
        this.total = total;
        this.customerID = customerID;
        this.employeeID = employeeID;
        this.serviceID = serviceID;
    }

    public Contract(int idContract, String startDateContract
            , String endDateContract, double deposit, double total, String customerID, String employeeID, String serviceID) {
        this.idContract = idContract;
        this.startDateContract = startDateContract;
        this.endDateContract = endDateContract;
        this.deposit = deposit;
        this.total = total;
        this.customerID = customerID;
        this.employeeID = employeeID;
        this.serviceID = serviceID;
    }

    public int getIdContract() {
        return idContract;
    }

    public void setIdContract(int idContract) {
        this.idContract = idContract;
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

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }
}
