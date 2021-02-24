package com.controller;

import com.model.Config;
import com.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ConfigController {
    @Autowired
    ConfigService configService;

    static List<String> languages = new ArrayList<>();

    static {
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Japanese");
        languages.add("Chinese");
    }

    static List<String> pages = new ArrayList<>();

    static {
        pages.add("5");
        pages.add("10");
        pages.add("15");
        pages.add("25");
        pages.add("50");
        pages.add("100");
    }

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("listConfig", configService.showAllConfig());
        return "home";
    }

    @RequestMapping("/detail/{id}")
    public String getDetail(@PathVariable(required = false) Integer id, Model model) {
        model.addAttribute("config", configService.showConfigById(id));
        model.addAttribute("languages", languages);
        model.addAttribute("pages", pages);
        return "detail";
    }

    @PostMapping("/update")
    public String updateConfig(@ModelAttribute Config config, RedirectAttributes redirectAttributes) {
        configService.saveConfig(config);
        redirectAttributes.addFlashAttribute("message", "Update!!");
        return "redirect:/";
    }
}
