package controllers;

import model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import services.StudentService;
import services.StudentServiceImpl;

import java.util.ArrayList;
import java.util.List;


@Controller
public class StudentController {
    StudentService studentService = new StudentServiceImpl();

    @GetMapping("/students")
    public ModelAndView getStudentPage(){
        return new ModelAndView("home", "listStudent", studentService.getAllStudent());
    }

    @GetMapping("/student/create")
    public String getCreateForm(Model model){
        model.addAttribute("student", new Student());
        List<String> cities = new ArrayList<>();
        cities.add("HN");
        cities.add("DN");
        cities.add("Vinh");
        model.addAttribute("cities", cities);
        return "create";
    }

    @PostMapping("/student/create")
    public String addNewStudent(@ModelAttribute Student student, RedirectAttributes model){
        studentService.createStudent(student);
        model.addFlashAttribute("message", "Created");
        return "redirect:/students";
    }

    @RequestMapping("/student_demo/detail/{id}")
    public String getDetailPage(@PathVariable(required = false) Integer id, Model model){
        if (id == null){
            System.out.println("Id không tồn tại");
            return "redirect:/students";
        }else {
            model.addAttribute("student", studentService.getStudentById(id));
            return "detail";
        }

    }
}
