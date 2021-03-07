package com.cart.controllers;

import com.cart.services.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MarketController {
    @Autowired
    ProductServiceImpl productService;

    @GetMapping("/")
    public String showHome(Model model, Pageable pageable){
        model.addAttribute("products", productService.findAllProduct(pageable));
        return "home";
    }

    @GetMapping("/view/{id}")
    public String viewProduct(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "view";
    }
}
