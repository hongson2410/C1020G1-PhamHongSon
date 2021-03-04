package com.codegym.controller;

import com.codegym.entity.Student;
import com.codegym.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

//    @Autowired
//    public StudentController(StudentService studentService) {
//        this.studentService = studentService;
//    }

    @GetMapping("/create")
    public String goHomePage(Model model) {
        this.studentService.getListOrderBy();
        model.addAttribute("student", new Student());

        return "create";
    }

    @PostMapping("/create")
    public String createStudent(@Valid @ModelAttribute Student student, BindingResult bindingResult) {

//        new Student().validate(student, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            return "create";
        }

        this.studentService.save(student);

        return "result";
    }
}
