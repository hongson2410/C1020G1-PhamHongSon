package com.customer.controller;

import com.customer.model.Customer;
import com.customer.model.Province;
import com.customer.service.CustomerService;
import com.customer.service.DuplicateEmailException;
import com.customer.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    private ProvinceService provinceService;

    @ModelAttribute("provinces")
    public Iterable<Province> provinces() {
        return provinceService.findAll();
    }

    @GetMapping("/create-customer")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create-customer")
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer) throws DuplicateEmailException {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }

    @GetMapping("/")
    public String listCustomers(@RequestParam("s") Optional<String> s, @PageableDefault(size = 3) Pageable pageable, Model model) {
        Page<Customer> customers;
        try {
            if (s.isPresent()) {
                customers = customerService.findAllByLastNameContaining(s.get(), pageable);
                model.addAttribute("customers", customers);
                return "search";
            } else {
                customers = customerService.findAll(pageable);
                model.addAttribute("customers", customers);
                return "list";
            }
        } catch (Exception e) {
            return "redirect:/";
        }
    }

    @GetMapping("/edit-customer/{id}")
    public ModelAndView showEditForm(@PathVariable int id) {
        try {
            Customer customer = customerService.findById(id);
            ModelAndView modelAndView = new ModelAndView("edit");
            modelAndView.addObject("customer", customer);
            return modelAndView;
        } catch (Exception e) {
            return new ModelAndView("redirect:/");
        }

    }

    @PostMapping("/edit-customer")
    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer) throws DuplicateEmailException {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message", "New customer update successfully");
        return modelAndView;
    }

    @GetMapping("/delete-customer/{id}")
    public ModelAndView showDeleteForm(@PathVariable int id) {
        try {
            Customer customer = customerService.findById(id);
            ModelAndView modelAndView = new ModelAndView("delete");
            modelAndView.addObject("customer", customer);
            return modelAndView;
        } catch (Exception e) {
            return new ModelAndView("redirect:/");
        }
    }

    @PostMapping("/delete-customer")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.delete(customer.getId());
        return "redirect:/";
    }

    @ExceptionHandler(DuplicateEmailException.class)
    public ModelAndView showInputNotAcceptable() {
        return new ModelAndView("inputs-not-acceptable");
    }
}
