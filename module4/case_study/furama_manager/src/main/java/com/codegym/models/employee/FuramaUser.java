package com.codegym.models.employee;

import javax.persistence.*;
import java.util.List;

@Entity
public class FuramaUser {
    @Id
    private String userName;

    private String password;

    @OneToMany(mappedBy = "furamaUser", cascade = CascadeType.ALL)
    private List<FuramaRoleUser> furamaRoleUsers;

    @OneToMany(mappedBy = "furamaUser" , cascade = CascadeType.ALL)
    private List<Employee> employees;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<FuramaRoleUser> getFuramaRoleUsers() {
        return furamaRoleUsers;
    }

    public void setFuramaRoleUsers(List<FuramaRoleUser> furamaRoleUsers) {
        this.furamaRoleUsers = furamaRoleUsers;
    }
}
