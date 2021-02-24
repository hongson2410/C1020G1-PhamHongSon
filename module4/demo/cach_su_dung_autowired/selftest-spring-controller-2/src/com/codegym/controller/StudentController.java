package com.codegym.controller;

import com.codegym.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

    @Qualifier("studentServiceImplOther")
    @Autowired
    private StudentService studentService;

    @GetMapping({"", "/list"})
    public String goStudentList(Model model) {
        model.addAttribute("listStudent", studentService.findAll());
        return "list_student";
    }

    @GetMapping("/detail")
    public String goDetailStudent(@RequestParam Integer id, Model model) {
        model.addAttribute("studentDetail", studentService.findById(id));
        return "detail_student";
    }

    @GetMapping("/detail/{id}")
    public String goDetailStudentPathVariable(@PathVariable Integer id, Model model) {
        model.addAttribute("studentDetail", studentService.findById(id));
        return "detail_student";
    }
}
