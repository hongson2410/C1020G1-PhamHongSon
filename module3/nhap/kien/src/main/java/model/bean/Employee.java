package model.bean;

public class Employee {
    private String employee_id;
    private String employee_name;
    private String employee_birthday;
    private int employee_gender;
    private String employee_id_card;
    private Double employee_salary;
    private String employee_phone;
    private String employee_email;
    private String employee_address;
    private int employee_position;

    public Employee(){

    }

    public Employee(String employee_name, String employee_birthday,
                    int employee_gender, Double employee_salary, String employee_phone,
                    String employee_email, String employee_address) {
        this.employee_name = employee_name;
        this.employee_birthday = employee_birthday;
        this.employee_gender = employee_gender;
        this.employee_salary = employee_salary;
        this.employee_phone = employee_phone;
        this.employee_email = employee_email;
        this.employee_address = employee_address;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmployee_birthday() {
        return employee_birthday;
    }

    public void setEmployee_birthday(String employee_birthday) {
        this.employee_birthday = employee_birthday;
    }

    public int getEmployee_gender() {
        return employee_gender;
    }

    public void setEmployee_gender(int employee_gender) {
        this.employee_gender = employee_gender;
    }

    public String getEmployee_id_card() {
        return employee_id_card;
    }

    public void setEmployee_id_card(String employee_id_card) {
        this.employee_id_card = employee_id_card;
    }

    public Double getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(Double employee_salary) {
        this.employee_salary = employee_salary;
    }

    public String getEmployee_phone() {
        return employee_phone;
    }

    public void setEmployee_phone(String employee_phone) {
        this.employee_phone = employee_phone;
    }

    public String getEmployee_email() {
        return employee_email;
    }

    public void setEmployee_email(String employee_email) {
        this.employee_email = employee_email;
    }

    public String getEmployee_address() {
        return employee_address;
    }

    public void setEmployee_address(String employee_address) {
        this.employee_address = employee_address;
    }

    public int getEmployee_position() {
        return employee_position;
    }

    public void setEmployee_position(int employee_position) {
        this.employee_position = employee_position;
    }

    public Employee(String employee_id, String employee_name, String employee_birthday, int employee_gender,
                    String employee_id_card, Double employee_salary, String employee_phone, String employee_email,
                    String employee_address, int employee_position) {
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.employee_birthday = employee_birthday;
        this.employee_gender = employee_gender;
        this.employee_id_card = employee_id_card;
        this.employee_salary = employee_salary;
        this.employee_phone = employee_phone;
        this.employee_email = employee_email;
        this.employee_address = employee_address;
        this.employee_position = employee_position;
    }
}
