package com.cart.controllers;

import com.cart.models.Product;
import com.cart.services.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("cart")
public class MarketController {
    @Autowired
    ProductServiceImpl productService;

    @ModelAttribute("cart")
    public List<Product> createCart() {
        return new ArrayList<>();
    }

    @GetMapping("/")
    public String showHome(Model model, Pageable pageable) {
        model.addAttribute("products", productService.findAllProduct(pageable));
        return "home";
    }

    @GetMapping("/view/{id}")
    public String viewProduct(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "view";
    }

    @GetMapping("/order/{id}")
    public String oderProduct(@ModelAttribute("cart") List<Product> cart, @PathVariable Integer id) {
        Product product = productService.findById(id);
        if (!cart.isEmpty()) {
            for (Product product1 : cart) {
                if (product.getId() == product1.getId()) {
                    product1.setQuantity(product1.getQuantity() + 1);
                    return "redirect:/";
                }
            }
        }
        product.setQuantity(1);
        cart.add(product);
        return "redirect:/";
    }

    @GetMapping("/show_cart")
    public String showCart(@ModelAttribute("cart") List<Product> cart, Model model) {
        model.addAttribute("cart", cart);
        return "cart";
    }

    @GetMapping("/plus/{id}")
    public String plusProductInCart(@ModelAttribute("cart") List<Product> cart, @PathVariable Integer id, Model model) {
        for (Product product : cart) {
            if (id == product.getId()) {
                product.setQuantity(product.getQuantity() + 1);
            }
        }
        model.addAttribute("cart", cart);
        return "cart";
    }

    @GetMapping("/minus/{id}")
    public String minusProductInCart(@ModelAttribute("cart") List<Product> cart, @PathVariable Integer id, Model model) {
        for (Product product : cart) {
            if (id == product.getId()) {
                if (product.getQuantity() == 1) {
                    cart.remove(product);
                    model.addAttribute("cart", cart);
                    return "cart";
                }
                product.setQuantity(product.getQuantity() - 1);
            }
        }
        model.addAttribute("cart", cart);
        return "cart";
    }

    @GetMapping("/delete_product/{id}")
    public String deleteProductInCart(@ModelAttribute("cart") List<Product> cart, @PathVariable Integer id, Model model) {
        if (id != 0) {
            for (Product product : cart) {
                if (id == product.getId()) {
                    cart.remove(product);
                    model.addAttribute("cart", cart);
                    return "cart";
                }
            }
        }
        cart.clear();
        return "redirect:/";
    }
}
