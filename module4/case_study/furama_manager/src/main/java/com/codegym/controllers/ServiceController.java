package com.codegym.controllers;

import com.codegym.models.service.RentTypeService;
import com.codegym.models.service.Service;
import com.codegym.models.service.TypeService;
import com.codegym.services.impl.service.RentTypeServiceImpl;
import com.codegym.services.impl.service.ServiceServiceImpl;
import com.codegym.services.impl.service.TypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("service")
public class ServiceController {

    @Autowired
    TypeServiceImpl typeService;

    @Autowired
    RentTypeServiceImpl rentTypeService;

    @Autowired
    ServiceServiceImpl serviceService;

    @ModelAttribute("typeServices")
    public List<TypeService> typeServices() {
        return typeService.findAllTypeService();
    }

    @ModelAttribute("rentTypeServices")
    public List<RentTypeService> rentTypeServices() {
        return rentTypeService.findAllRentTypeService();
    }

    @ModelAttribute("service")
    public Service service() {
        return new Service();
    }

    @GetMapping("/list")
    public String showListService(@RequestParam(value = "page",defaultValue = "0",required = false) int page, Model model) {
        Pageable pageable = PageRequest.of(page,5);
        Page<Service> services = serviceService.findAllService(pageable);
        model.addAttribute("services", services);
        return "service/list_service";
    }

    @GetMapping("/createVilla")
    public String showFormCreateVilla() {
        return "service/create_villa";
    }

    @GetMapping("/createHouse")
    public String showFormCreateHouse() {
        return "service/create_house";
    }

    @GetMapping("/createRoom")
    public String showFormCreateRoom() {
        return "service/create_room";
    }

    @PostMapping("/create")
    public String createService(@Validated @ModelAttribute("service") Service service,BindingResult bindingResult,
                                RedirectAttributes redirectAttributes, @RequestParam("string") String string) {
        if (bindingResult.hasFieldErrors()){
            switch (string){
                case "villa":
                    return "service/create_villa";
                case "house":
                    return "service/create_house";
                default:
                    return "service/create_room";
            }
        }
        serviceService.saveService(service);
        redirectAttributes.addFlashAttribute("message", "Service was create!");
        return "/service/list_service";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable String id, Model model) {
        Service service = serviceService.findById(id);
        switch (service.getTypeService().getServiceTypeName()){
            case "Villa":
                model.addAttribute("service", service);
                return "/service/edit_villa";
            case "House":
                model.addAttribute("service", service);
                return "/service/edit_house";
            default:
                model.addAttribute("service", service);
                return "/service/edit_room";
        }
    }

    @PostMapping("/edit")
    public String editService(@Validated @ModelAttribute("service") Service service,BindingResult bindingResult,
                              RedirectAttributes redirectAttributes,@RequestParam("string") String string) {
        if (bindingResult.hasFieldErrors()){
            switch (string){
                case "villa":
                    return "service/edit_villa";
                case "house":
                    return "service/edit_house";
                default:
                    return "service/edit_room";
            }
        }
        serviceService.saveService(service);
        redirectAttributes.addFlashAttribute("message", "Service " + service.getServiceId() + " was update!");
        return "redirect:/contract/listContractUsing";
    }

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam("id") String id, RedirectAttributes redirectAttributes){
        serviceService.deleteService(id);
        redirectAttributes.addFlashAttribute("message", "Service "+id+" was delete!");
        return "redirect:/service/list";
    }
}
