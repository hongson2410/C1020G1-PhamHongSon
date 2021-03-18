package com.codegym.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String showHome(){
        return "home";
    }

    @GetMapping("/login")
    public String showLogin(){
        return "login/loginPage";
    }
}
