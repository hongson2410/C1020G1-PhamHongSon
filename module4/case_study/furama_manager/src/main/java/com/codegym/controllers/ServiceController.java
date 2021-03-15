package com.codegym.controllers;

import com.codegym.models.service.RentTypeService;
import com.codegym.models.service.Service;
import com.codegym.models.service.TypeService;
import com.codegym.services.impl.RentTypeServiceImpl;
import com.codegym.services.impl.ServiceServiceImpl;
import com.codegym.services.impl.TypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String showListService(@PageableDefault(size = 5) Pageable pageable, Model model) {
        Page<Service> services = serviceService.findAllService(pageable);
        for (Service service : services.getContent()) {
            service.setCost(service.getRentTypeService().getRentTypeCost() * service.getMax_people());
        }
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
    public String createService(@ModelAttribute Service service, RedirectAttributes redirectAttributes) {
        serviceService.createService(service);
        redirectAttributes.addFlashAttribute("message", "Service was create!");
        return "redirect:/service/list";
    }
}
