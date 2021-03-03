package com.blog.controller;

import com.blog.model.Category;
import com.blog.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CategoryController {
    @Autowired
    CategoryServiceImpl categoryService;

    @GetMapping("/category")
    public String showCategory(@PageableDefault(size = 2) Pageable pageable, Model model){
        model.addAttribute("categoryList", categoryService.findAllCategory(pageable));
        return "category/home";
    }

    @GetMapping("/create_category")
    public String showFormCreateCategory(Model model){
        model.addAttribute("category", new Category());
        return "/category/create";
    }

    @PostMapping("/create_category")
    public String createCategory(@ModelAttribute Category category, Model model){
        categoryService.saveCategory(category);
        model.addAttribute("message","New category created successfully");
        model.addAttribute("category", new Category());
        return "/category/create";
    }

    @GetMapping("/edit_category/{id}")
    public String showFormEditCategory(@PathVariable Integer id, Model model){
        model.addAttribute("category", categoryService.findByIdCategory(id));
        return "/category/edit";
    }

    @PostMapping("/edit_category")
    public String editCategory(@ModelAttribute Category category, RedirectAttributes redirectAttributes){
        categoryService.saveCategory(category);
        redirectAttributes.addFlashAttribute("message", "Category update successfully");
        return "redirect:/category";
    }

    @PostMapping("/delete_category")
    public String deleteCategory(@ModelAttribute(name = "id") Integer id, RedirectAttributes redirectAttributes){
        categoryService.deleteByIdCategory(id);
        redirectAttributes.addFlashAttribute("message", "Category delete successfully");
        return "redirect:/category";
    }
}
