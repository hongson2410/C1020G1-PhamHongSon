package com.codegym.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    private ClassCodeGym classCodeGym;

}
