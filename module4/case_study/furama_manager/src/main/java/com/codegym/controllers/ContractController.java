package com.codegym.controllers;

import com.codegym.models.contract.AttachService;
import com.codegym.models.contract.Contract;
import com.codegym.models.contract.ContractDetail;
import com.codegym.models.customer.Customer;
import com.codegym.models.employee.Employee;
import com.codegym.models.service.Service;
import com.codegym.repositories.contract.AttachServiceRepository;
import com.codegym.repositories.customer.CustomerRepository;
import com.codegym.repositories.employee.EmployeeRepository;
import com.codegym.repositories.service.ServiceRepository;
import com.codegym.services.EmployeeService;
import com.codegym.services.impl.contract.AttachServiceServiceImpl;
import com.codegym.services.impl.contract.ContractDetailServiceImpl;
import com.codegym.services.impl.contract.ContractServiceImpl;
import com.codegym.services.impl.customer.CustomerServiceImpl;
import com.codegym.services.impl.employee.EmployeeServiceImpl;
import com.codegym.services.impl.service.ServiceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    ContractDetailServiceImpl contractDetailService;
    @Autowired
    ContractServiceImpl contractService;
    @Autowired
    AttachServiceServiceImpl attachServiceService;
    @Autowired
    CustomerServiceImpl customerService;
    @Autowired
    EmployeeServiceImpl employeeService;
    @Autowired
    ServiceServiceImpl serviceService;

    @ModelAttribute("customers")
    public Page<Customer> customers(Pageable pageable) {
        return customerService.findAllCustomer(pageable);
    }

    @ModelAttribute("employees")
    public Page<Employee> employees(Pageable pageable) {
        return employeeService.findAllEmployee(pageable);
    }

    @ModelAttribute("services")
    public Page<Service> services(Pageable pageable) {
        return serviceService.findAllService(pageable);
    }

    @ModelAttribute("contracts")
    public Page<Contract> contracts(Pageable pageable) {
        return contractService.findAllContract(pageable);
    }

    @ModelAttribute("attachServices")
    public List<AttachService> attachServices() {
        return attachServiceService.findAllAttachService();
    }

    @GetMapping("/list")
    public String showContract(@RequestParam(value = "page", defaultValue = "0", required = false) int page, Model model) {
        Pageable pageable = PageRequest.of(page, 5);
        model.addAttribute("contracts", contractService.findAllContract(pageable));
        return "/contract/list_contract";
    }

    @GetMapping("/create")
    public String showFormCreateContract(Model model) {
        model.addAttribute("contract", new Contract());
        return "/contract/create_contract";
    }

    @PostMapping("/create")
    public String createContract(@ModelAttribute("contract") Contract contract, RedirectAttributes redirectAttributes) {
        contractService.saveContract(contract);
        redirectAttributes.addFlashAttribute("message", "Contract was create!");
        return "redirect:/contract/list";
    }

    @GetMapping("/createContractDetail")
    public String showFormContractDetail(Model model) {
        model.addAttribute("contractDetail", new ContractDetail());
        return "/contract/create_contract_detail";
    }

    @PostMapping("/createContractDetail")
    public String createContractDetail(@ModelAttribute("contractDetail") ContractDetail contractDetail, RedirectAttributes redirectAttributes) {
        contractDetailService.saveContractDetail(contractDetail);
        redirectAttributes.addFlashAttribute("message", "Contract Detail was create!");
        return "redirect:/contract/list";
    }

    @GetMapping("/listContractUsing")
    public String contractUsing(@RequestParam(value = "page", defaultValue = "0", required = false) int page, Model model) {
        Pageable pageable = PageRequest.of(page, 5);
        model.addAttribute("contracts", contractService.findAllContractUsing(LocalDate.now().toString(), pageable));
        return "/contract/list_contract_using";
    }

    @PostMapping("/search")
    public String searchContractUsingByCustomerCode(@RequestParam("customerName") String customer, Model model) {
        List<Contract> contracts = contractService.findContractUsingByCodeCustomer(LocalDate.now().toString(),
                customer);
        if (contracts.isEmpty()) {
            model.addAttribute("message", "not found!");
            return "/contract/search_list_contract_using";
        }
        model.addAttribute("contracts", contracts);
        return "/contract/search_list_contract_using";
    }
}
