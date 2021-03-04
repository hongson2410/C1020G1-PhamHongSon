package com.codegym.entity;

import com.codegym.annotation.ExistC10;
import lombok.Data;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Data
public class Student implements Validator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @Pattern(regexp = "[A-Za-z ]+", message = "Format wrong")
    @ExistC10
    private String name;

    @Column(columnDefinition = "date")
    private String dateOfBirth;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    // target: student
    // errors: bindingResult
    @Override
    public void validate(Object target, Errors errors) {
        Student student = (Student) target;

        if (!student.name.matches("[A-Za-z ]+")) {
            errors.rejectValue("name", "student.name.format");
        }

        int year = Integer.parseInt(student.dateOfBirth.substring(0, 4));

        if (year >= 2003) {
            errors.rejectValue("dateOfBirth", "student.dateOfBirth.invalid");
        }

    }
}
