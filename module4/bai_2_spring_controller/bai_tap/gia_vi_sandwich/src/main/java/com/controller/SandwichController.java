package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.awt.ModalExclude;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SandwichController {

    @GetMapping("/")
    public String home(){
        return "/index";
    }

    @GetMapping("/my_sandwich")
    public String mySandwich(@RequestParam(required = false) String condiments, Model model){
        List<String> listCondiments = new ArrayList<>();

        if (condiments == null){
            model.addAttribute("message","Please choose!!!");
            return "/index";
        } else {
            listCondiments.add(condiments);
            model.addAttribute("listCondiment", listCondiments);
            return "/my_sandwich";
        }
    }
}
