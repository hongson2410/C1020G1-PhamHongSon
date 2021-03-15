package com.codegym.models.employee;

import javax.persistence.*;

@Entity
public class FuramaRoleUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRoleUser;

    @ManyToOne
    @JoinColumn(name = "user_name",referencedColumnName = "userName")
    private FuramaUser furamaUser;

    @ManyToOne
    @JoinColumn(name = "role_id",referencedColumnName = "roleId")
    private FuramaRole furamaRole;

    public Integer getIdRoleUser() {
        return idRoleUser;
    }

    public void setIdRoleUser(Integer idRoleUser) {
        this.idRoleUser = idRoleUser;
    }

    public FuramaUser getFuramaUser() {
        return furamaUser;
    }

     public void setFuramaUser(FuramaUser furamaUser) {
        this.furamaUser = furamaUser;
    }

    public FuramaRole getFuramaRole() {
        return furamaRole;
    }

    public void setFuramaRole(FuramaRole furamaRole) {
        this.furamaRole = furamaRole;
    }
}
