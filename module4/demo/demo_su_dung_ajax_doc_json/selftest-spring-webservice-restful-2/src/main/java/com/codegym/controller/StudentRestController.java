package com.codegym.controller;

import com.codegym.entity.Student;
import com.codegym.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/apiStudent")
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/list")
    public ResponseEntity<List<Student>> getListStudent() {

        List<Student> studentList = studentService.findAll();

        if(studentList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Student> getDetailStudent(@PathVariable Integer id) throws Exception {
        Student student = null;
        try {
            student = studentService.findById(id);


            if(student == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Void> registerStudent(@RequestBody Student student) {
        this.studentService.save(student);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
