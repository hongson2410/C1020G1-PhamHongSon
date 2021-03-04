package com.user.controller;

import com.user.model.User;
import com.user.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/")
    public String showHome(Model model) {
        model.addAttribute("users", userService.findAll());
        return "home";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("user_create", new User());
        return "create";
    }

    @PostMapping("/create")
    public String createUser(@Validated @ModelAttribute(name = "user_create") User user, BindingResult bindingResult,
                             Model model, RedirectAttributes redirectAttributes) {
        new User().validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("user_create", user);
            return "/create";
        } else {
            userService.save(user);
            redirectAttributes.addFlashAttribute("message", "New user created successfully");
            return "redirect:/";
        }
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable(name = "id") Integer id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String editUser(@Validated @ModelAttribute(name = "user") User user, BindingResult bindingResult,
                           Model model, RedirectAttributes redirectAttributes) {
        new User().validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", user);
            return "/edit";
        } else {
            userService.save(user);
            redirectAttributes.addFlashAttribute("message", "User update successfully");
            return "redirect:/";
        }
    }

    @GetMapping("/delete")
    public String deleteUser(@ModelAttribute(name = "id") Integer id, RedirectAttributes redirectAttributes) {
        userService.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "User delete successfully");
        return "redirect:/";
    }
}
