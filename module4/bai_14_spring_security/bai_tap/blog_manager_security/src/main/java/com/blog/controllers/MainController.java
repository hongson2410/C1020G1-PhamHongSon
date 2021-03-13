package com.blog.controllers;

import com.blog.models.AppUser;
import com.blog.models.Category;
import com.blog.repositories.AppUserRepository;
import com.blog.services.impl.CategoryServiceImpl;
import com.blog.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class MainController {

    @Autowired
    CategoryServiceImpl categoryService;

    @Autowired
    AppUserRepository appUserRepository;

    @ModelAttribute("categories")
    public Iterable<Category> categories() {
        return categoryService.findAllCategory();
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        return "/blog/home_guest";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
        AppUser appUser = appUserRepository.findById(Long.parseLong("1")).orElse(null);
        appUser.setEncrytedPassword(new BCryptPasswordEncoder().encode("123456"));
        appUserRepository.save(appUser);
        appUser = appUserRepository.findById(Long.parseLong("2")).orElse(null);
        appUser.setEncrytedPassword(new BCryptPasswordEncoder().encode("123456"));
        appUserRepository.save(appUser);
        return "/login/loginPage";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model, Principal principal) {
        User loggedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loggedUser);
        model.addAttribute("userInfo", userInfo);

        return "/blog/home";
    }

    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "/blog/home_guest";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            User loggedUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtils.toString(loggedUser);

            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);

        }

        return "/login/403Page";
    }
}
