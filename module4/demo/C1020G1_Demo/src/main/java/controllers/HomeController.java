package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @GetMapping("/login")
    public String getHomePage() {
        return "index";
    }

    @PostMapping
    public String login(@RequestParam(name = "username") String name, @RequestParam("password") String pass) {
        if ("trungdoan".equals(name) && "123123".equals(pass)) {
            System.out.println("Login thành công");
        } else {
            System.out.println("Login sai");
        }
        return "index";
    }

    @GetMapping("/product/{id}")
    public String getProductDetail(@PathVariable int id) {
        System.out.println(id);
        return "index";
    }
}
