package com.product.controller;

import com.product.model.Product;
import com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String createProduct (@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        product.setId((int)(Math.random()* 10000));
        productService.save(product);
        redirectAttributes.addFlashAttribute("message","1 product has just been CREATE !!!");
        return "redirect:/";
    }

    @GetMapping("/product/{id}/edit")
    public String showFormEdit(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }

    @PostMapping("/product/update")
    public String updateProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        productService.update(product.getId(), product);
        redirectAttributes.addFlashAttribute("message","1 product has just been UPDATE !!!");
        return "redirect:/";
    }

    @GetMapping("/product/{id}/delete")
    public String showFormDelete(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "delete";
    }

    @PostMapping("/product/delete")
    public String deleteProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        productService.remove(product.getId());
        redirectAttributes.addFlashAttribute("message","1 product has just been DELETE !!!");
        return "redirect:/";
    }

    @GetMapping("/product/{id}/view")
    public String showProduct(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "view";
    }
}
