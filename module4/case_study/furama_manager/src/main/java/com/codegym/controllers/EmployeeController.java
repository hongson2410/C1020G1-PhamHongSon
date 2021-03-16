package com.codegym.controllers;

import com.codegym.models.employee.Division;
import com.codegym.models.employee.Education;
import com.codegym.models.employee.Employee;
import com.codegym.models.employee.Position;
import com.codegym.services.impl.DivisionServiceImpl;
import com.codegym.services.impl.EducationServiceImpl;
import com.codegym.services.impl.EmployeeServiceImpl;
import com.codegym.services.impl.PositionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EducationServiceImpl educationService;

    @Autowired
    PositionServiceImpl positionService;

    @Autowired
    DivisionServiceImpl divisionService;

    @Autowired
    EmployeeServiceImpl employeeService;

    @ModelAttribute("educations")
    public List<Education> educations(){
        return educationService.findAllEducation();
    }

    @ModelAttribute("positions")
    public List<Position> positions(){
        return positionService.findAllPosition();
    }

    @ModelAttribute("divisions")
    public List<Division> divisions(){
        return divisionService.findAllDivision();
    }

    @GetMapping("/list")
    public String showListEmployee(@RequestParam(value = "page",defaultValue = "0",required = false) int page, Model model){
        Pageable pageable = PageRequest.of(page,5);
        model.addAttribute("employees", employeeService.findAllEmployee(pageable));
        return "/employee/list_employee";
    }

    @GetMapping("/create")
    public String showFormCreateEmployee(Model model){
        model.addAttribute("employee", new Employee());
        return "/employee/create_employee";
    }

    @PostMapping("/create")
    public String createEmployee(@ModelAttribute("employee") Employee employee, RedirectAttributes redirectAttributes){
        employeeService.saveEmployee(employee);
        redirectAttributes.addFlashAttribute("message", "Employee was create!!");
        return "redirect:/employee/create";
    }

    @GetMapping("/edit/{id}")
    public String showFormEditEmployee(@PathVariable Integer id, Model model){
        model.addAttribute("employee", employeeService.findEmployeeById(id));
        return "/employee/edit_employee";
    }

    @PostMapping("/edit")
    public String editEmployee(@ModelAttribute Employee employee, RedirectAttributes redirectAttributes){
        employeeService.saveEmployee(employee);
        redirectAttributes.addFlashAttribute("message", "Employee was update!");
        return "redirect:/employee/list";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes){
        employeeService.deleteEmployeeById(id);
        redirectAttributes.addFlashAttribute("message", "Employee was delete!");
        return "redirect:/employee/list";
    }

    @PostMapping("/search")
    public String findCustomerByName(@RequestParam("employeeName") String employeeName, Model model){
        model.addAttribute("employees", employeeService.findByEmployeeNameContaining(employeeName));
        return "/employee/search_employee";
    }
}
