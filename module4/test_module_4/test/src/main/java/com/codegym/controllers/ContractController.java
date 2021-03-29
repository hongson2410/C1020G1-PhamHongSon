package com.codegym.controllers;

import com.codegym.models.Contract;
import com.codegym.models.Customer;
import com.codegym.services.impl.ContractServiceImpl;
import com.codegym.services.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ContractController {
    @Autowired
    CustomerServiceImpl customerService;

    @Autowired
    ContractServiceImpl contractService;

    @ModelAttribute("customers")
    public List<Customer> customers() {
        return customerService.findAllCustomer();
    }

    @GetMapping("/contractList")
    public String showListContract(@RequestParam(value = "page", defaultValue = "0", required = false) int page, Model model) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Contract> contracts = contractService.findAllContract(pageable);
        model.addAttribute("contracts", contracts);
        return "contract/list";
    }

    @GetMapping("/contractDetail/{id}")
    public String getContractDetail(@PathVariable Integer id, Model model) {
        Contract contract = contractService.findContractById(id);
        model.addAttribute("contract", contract);
        return "contract/detail";
    }

    @GetMapping("/contractCreate")
    public String showFormCreate(Model model) {
        model.addAttribute("contract", new Contract());
        return "contract/create";
    }

    @PostMapping("/contractCreate")
    public String createContract(@Validated @ModelAttribute("contract") Contract contract, BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("contract", contract);
            return "contract/create";
        }
        contractService.saveContract(contract);
        redirectAttributes.addFlashAttribute("message", "Contract was create");
        return "redirect:/contractList";
    }

    @PostMapping("/deleteContract")
    public String deleteContract(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes) {
        contractService.deleteContract(id);
        redirectAttributes.addFlashAttribute("message", "Contract was delete");
        return "redirect:/contractList";
    }

    @GetMapping(value = "/contractSearch",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Contract>> searchContract(@RequestParam("name") String name){
        return new ResponseEntity<>(contractService.findByServiceTypeContainingOrCustomer_CustomerNameContaining(name), HttpStatus.OK);
    }
}
