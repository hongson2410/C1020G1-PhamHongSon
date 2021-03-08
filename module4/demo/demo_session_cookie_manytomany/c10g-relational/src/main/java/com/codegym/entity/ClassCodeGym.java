package com.codegym.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class ClassCodeGym {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "classCodeGym")
    private List<Student> studentList;

    @OneToMany(mappedBy = "classCodeGym")
    private List<InstructorTeachClass> instructorTeachClassList;
}
