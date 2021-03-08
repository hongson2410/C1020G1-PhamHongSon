package com.codegym.controller;

import com.codegym.entity.ClassCodeGym;
import com.codegym.entity.Instructor;
import com.codegym.entity.InstructorTeachClass;
import com.codegym.service.ClassCodeGymService;
import com.codegym.service.InstructorService;
import com.codegym.service.InstructorTeachClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InstructorTeachClassController {

    @Autowired
    private InstructorService instructorService;

    @Autowired
    private ClassCodeGymService classCodeGymService;

    @Autowired
    private InstructorTeachClassService instructorTeachClassService;

    @GetMapping("/registerITC")
    public String registerInstructorTeachClass() {
//        // TrungDP
//        Integer instructorId = 2;
//
//        // C1020G1
//        Integer classId = 2;
//
//        Instructor instructor = this.instructorService.findById(instructorId);
//        ClassCodeGym classCodeGym = this.classCodeGymService.findById(classId);

        Instructor instructor = new Instructor("Hai", "2021-03-10");
        this.instructorService.save(instructor);

        // C1020G1
        Integer classId = 2;
        ClassCodeGym classCodeGym = this.classCodeGymService.findById(classId);

        InstructorTeachClass instructorTeachClass = new InstructorTeachClass();
        instructorTeachClass.setInstructor(instructor);
        instructorTeachClass.setClassCodeGym(classCodeGym);

        this.instructorTeachClassService.save(instructorTeachClass);

        return "/ok";
    }
}
