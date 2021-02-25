package com.product.controller;

import com.product.model.Product;
import com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("productList", productService.findAll());
        return "index";
    }

    @RequestMapping("/product/create")
    public String showFormCreate (Model model){
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/product/create")
    public String createProduct (@ModelAttribute Product product){
        product.setId((int)(Math.random()* 10000));
        productService.save(product);
        return "redirect:/";
    }
}
