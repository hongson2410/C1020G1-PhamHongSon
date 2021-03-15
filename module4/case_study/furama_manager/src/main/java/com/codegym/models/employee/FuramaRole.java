package com.codegym.models.employee;

import javax.persistence.*;
import java.util.List;

@Entity
public class FuramaRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;

    private String roleName;

    @OneToMany(mappedBy = "furamaRole", cascade = CascadeType.ALL)
    private List<FuramaRoleUser> furamaRoleUsers;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<FuramaRoleUser> getFuramaRoleUsers() {
        return furamaRoleUsers;
    }

    public void setFuramaRoleUsers(List<FuramaRoleUser> furamaRoleUsers) {
        this.furamaRoleUsers = furamaRoleUsers;
    }
}
