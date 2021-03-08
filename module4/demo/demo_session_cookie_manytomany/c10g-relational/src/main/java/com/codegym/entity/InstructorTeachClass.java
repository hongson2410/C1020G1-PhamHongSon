package com.codegym.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
public class InstructorTeachClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "instructor_id", referencedColumnName = "id")
    private Instructor instructor;

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    private ClassCodeGym classCodeGym;

    private String note;

    public InstructorTeachClass() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public ClassCodeGym getClassCodeGym() {
        return classCodeGym;
    }

    public void setClassCodeGym(ClassCodeGym classCodeGym) {
        this.classCodeGym = classCodeGym;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
