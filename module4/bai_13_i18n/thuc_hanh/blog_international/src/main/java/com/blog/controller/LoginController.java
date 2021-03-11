package com.blog.controller;

import com.blog.model.Credential;
import com.blog.model.User;
import org.hibernate.annotations.Parameter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("user")
public class LoginController {
    
    @GetMapping("/login")
    public String login(@ModelAttribute("credential") Credential credential,
                        @RequestParam(value = "lang",required = false) String lang, Model model) {
        if (lang == null){
            lang="en";
        }
        model.addAttribute("lang", lang);
        return "login";
    }

    @PostMapping("/login")
    public String dashboard(@ModelAttribute("credential") Credential credential, Model model) {
        User user = new User();
        user.setUserName(credential.getUsername());
        model.addAttribute("user", user);
        return "redirect:/dashboard";
    }
}
