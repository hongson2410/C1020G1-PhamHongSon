package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {

    @GetMapping("")
    public String money () {
        return "/money";
    }

    @GetMapping("/currency")
    public String currency (@RequestParam String usd, String rate ,Model model) {
        int vnd = Integer.parseInt(usd)*Integer.parseInt(rate);
        model.addAttribute("vnd",vnd);
        model.addAttribute("usd",usd);
        model.addAttribute("rate",rate);
        return "/currency";
    }

}
