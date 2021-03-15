package com.codegym.controllers;

import com.codegym.models.customer.Customer;
import com.codegym.models.customer.CustomerType;
import com.codegym.services.impl.CustomerServiceImpl;
import com.codegym.services.impl.CustomerTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerServiceImpl customerService;

    @Autowired
    CustomerTypeServiceImpl customerTypeService;

    @ModelAttribute("customerTypes")
    public List<CustomerType> customerTypes(){
        return customerTypeService.findAllCustomerType();
    }

    @GetMapping("/list")
    public String showListCustomer(@RequestParam(value = "page",defaultValue = "0",required = false) int page, Model model){
        Pageable pageable = PageRequest.of(page,5);
        Page<Customer> customerPage = customerService.findAllCustomer(pageable);
        model.addAttribute("listCustomer", customerPage);
        return "customer/list_customer";
    }

    @GetMapping("/create")
    public String showFormCreateCustomer(Model model){
        model.addAttribute("customer", new Customer());
        return "/customer/create_customer";
    }

    @PostMapping("/create")
    public String createCustomer(@ModelAttribute("customer") Customer customer, Model model,RedirectAttributes redirectAttributes){
        customerService.saveCustomer(customer);
//        model.addAttribute("message", "New Customer was create!");
        redirectAttributes.addFlashAttribute("message", "New Customer was create!");
        return "redirect:/customer/create";
    }

    @GetMapping("/edit/{id}")
    public String showFormEditCustomer(@PathVariable("id") Integer id, Model model){
        Customer customer = customerService.findCustomerById(id);
        model.addAttribute("customer", customer);
        return "/customer/edit_customer";
    }

    @PostMapping("/edit")
    public String editCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes){
        customerService.saveCustomer(customer);
        redirectAttributes.addFlashAttribute("message", "Customer "+customer.getCustomerId()+" was update!");
        return "redirect:/customer/list";
    }

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes){
        customerService.deleteCustomer(id);
        redirectAttributes.addFlashAttribute("message", "Customer "+id+" was delete!");
        return "redirect:/customer/list";
    }

    @PostMapping("/search")
    public String findCustomerByName(@RequestParam("customerName") String customerName, Model model){
        model.addAttribute("listCustomer", customerService.findByCustomerNameContaining(customerName));
        return "/customer/list_customer";
    }
}
