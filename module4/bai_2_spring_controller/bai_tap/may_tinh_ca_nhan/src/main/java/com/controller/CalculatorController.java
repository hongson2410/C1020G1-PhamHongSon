package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam("input_1") double input_1, @RequestParam("input_2") double input_2,
                             @RequestParam("operator") String operator, Model model) {
        double result;
        switch (operator) {
            case "Addition(+)":
                result = input_1 + input_2;
                break;
            case "Subtraction(-)":
                result = input_1 - input_2;
                break;
            case "Multiplication(X)":
                result = input_1 * input_2;
                break;
            default:
                result = input_1 / input_2;
        }
        model.addAttribute("result", result);
        model.addAttribute("input_1", input_1);
        model.addAttribute("input_2", input_2);
        return "index";
    }
}
