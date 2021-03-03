package com.blog.controller;

import com.blog.model.Blog;
import com.blog.model.Category;
import com.blog.service.impl.BlogServiceImpl;
import com.blog.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;


@Controller
public class BlogController {
    @Autowired
    BlogServiceImpl blogService;

    @Autowired
    CategoryServiceImpl categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories(Pageable pageable) {
        return categoryService.findAllCategory(pageable);
    }

    @GetMapping("/")
    public String showHome(@PageableDefault(size = 5) Pageable pageable, Model model) {
        model.addAttribute("blogList", blogService.findAll(pageable));
        return "home";
    }

    @GetMapping("search_name")
    public String searchByName(@PageableDefault(size = 5) Pageable pageable, Model model, @RequestParam(name = "nameBlog") String blogName) {
        model.addAttribute("blogList", blogService.findByBlogNameContaining(pageable, blogName));
        return "search";
    }

    @GetMapping("search_category")
    public String searchByCategory(@PageableDefault(size = 5) Pageable pageable, Model model, @RequestParam(name = "id")
                                   Integer id) {
        model.addAttribute("blogList", blogService.findByCategory(pageable, id));
        return "search";
    }

    @GetMapping("create")
    public String showFormCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("create")
    public String createBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blog.setDateUpdate(new Date());
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "New blog created successfully");
        return "redirect:/";
    }

    @GetMapping("edit/{id}")
    public String showFormEdit(@PathVariable Integer id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "edit";
    }

    @PostMapping("edit")
    public String editBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blog.setDateUpdate(new Date());
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "This blog edit successfully");
        return "redirect:/";
    }

    @PostMapping("delete")
    public String deleteBlog(@ModelAttribute(name = "id") Integer id, RedirectAttributes redirectAttributes) {
        blogService.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "This blog delete successfully");
        return "redirect:/";
    }

    @GetMapping("view/{id}")
    public String showBlog(@PathVariable Integer id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "view";
    }
}
