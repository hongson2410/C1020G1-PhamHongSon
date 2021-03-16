package com.codegym.controllers;

import com.codegym.models.contract.AttachService;
import com.codegym.models.contract.Contract;
import com.codegym.models.contract.ContractDetail;
import com.codegym.repositories.contract.AttachServiceRepository;
import com.codegym.services.impl.contract.AttachServiceServiceImpl;
import com.codegym.services.impl.contract.ContractDetailServiceImpl;
import com.codegym.services.impl.contract.ContractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @ModelAttribute("attachServices")
    public List<AttachService> attachServices(){
        return attachServiceService.findAllAttachService();
    }

    @GetMapping("/list")
    public String showContract(@RequestParam(value = "page", defaultValue = "0", required = false) int page, Model model){
        Pageable pageable= PageRequest.of(page,5);
        model.addAttribute("contracts",contractService.findAllContract(pageable));
        return "/contract/list_contract";
    }

    @GetMapping("/create")
    public String showFormCreateContract(Model model){
        model.addAttribute("contract",new Contract());
        return "/contract/create_contract";
    }

    @PostMapping("/create")
    public String createContract(@ModelAttribute("contract") Contract contract, RedirectAttributes redirectAttributes){
        contractService.saveContract(contract);
        redirectAttributes.addFlashAttribute("message", "Contract was create!");
        return "redirect:/contract/list";
    }

    @GetMapping("/createContractDetail")
    public String showFormContractDetail(Model model){
        model.addAttribute("contractDetail", new ContractDetail());
        return "/contract/create_contract_detail";
    }

    @PostMapping("/createContractDetail")
    public String createContractDetail(@ModelAttribute("contractDetail") ContractDetail contractDetail, RedirectAttributes redirectAttributes){
        contractDetailService.saveContractDetail(contractDetail);
        redirectAttributes.addFlashAttribute("message","Contract Detail was create!");
        return "redirect:/contract/list";
    }
}
