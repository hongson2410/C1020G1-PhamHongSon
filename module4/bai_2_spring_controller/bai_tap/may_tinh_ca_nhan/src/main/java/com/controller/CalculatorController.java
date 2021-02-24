package com.controller;

import com.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    CalculatorService calculatorService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam("input_1") double input_1, @RequestParam("input_2") double input_2,
                             @RequestParam("operator") String operator, Model model) {
        model.addAttribute("result", calculatorService.calculator(input_1, input_2, operator));
        model.addAttribute("input_1", input_1);
        model.addAttribute("input_2", input_2);
        return "index";
    }
}
