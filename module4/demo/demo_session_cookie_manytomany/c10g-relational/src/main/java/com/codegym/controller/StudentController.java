package com.codegym.controller;

import com.codegym.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
public class StudentController {


    // C1
//    @GetMapping("/home")
//    public String goHome(HttpServletRequest httpServletRequest, Model model) {
//        User user = (User) httpServletRequest.getSession().getAttribute("userLogin");
//
//        model.addAttribute("userLogin", user);
//
//        return "/student/list";
//    }

    // C2
    @GetMapping("/home")
    public String goHome(@SessionAttribute("userLogin") User user, Model model) {

        model.addAttribute("userLogin", user);

        return "/student/list";
    }
}
