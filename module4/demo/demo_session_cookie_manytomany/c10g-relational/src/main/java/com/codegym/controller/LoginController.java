package com.codegym.controller;

import com.codegym.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes({"userLogin", "student"})
public class LoginController {

    @ModelAttribute("userLogin")
    public User createUserLogin() {
        return new User();
    }

    @GetMapping("/login")
    public String goLogin(Model model,
                          @CookieValue(name = "usernameCookie", defaultValue = "") String usernameCookie) {
        model.addAttribute("userLogin", new User(usernameCookie, ""));
        return "login";
    }

    //C1
//    @PostMapping("/checkLogin")
//    public String checkLogin(@ModelAttribute("userLogin") User user, HttpServletRequest httpServletRequest) {
//        // check login...
//
//        // save to session
//        httpServletRequest.getSession().setAttribute("userLogin", user);
//
//        return "redirect:/home";
//    }

    //C2
    @PostMapping("/checkLogin")
    public String checkLogin(@ModelAttribute("userLogin") User user,
                             HttpServletResponse httpServletResponse) {
        Cookie usernameCookie = new Cookie("usernameCookie", user.getUsername());
        usernameCookie.setMaxAge(15);
        httpServletResponse.addCookie(usernameCookie);

        System.out.println(user);
        return "redirect:/home";
    }

}
