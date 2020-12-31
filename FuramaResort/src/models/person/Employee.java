package models.person;

public class Employee {
    private String fullName;
    private String id;
    private int age;
    private String address;

    public Employee(String fullName, String id, int age, String address) {
        this.fullName = fullName;
        this.id = id;
        this.age = age;
        this.address = address;
    }

    public Employee() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return fullName + ','
                + id + ','
                + age + ','
                + address;
    }
}
