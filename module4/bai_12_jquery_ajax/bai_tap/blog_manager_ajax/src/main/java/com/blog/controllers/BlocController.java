package com.blog.controllers;

import com.blog.models.Blog;
import com.blog.models.Category;
import com.blog.service.impl.BlogServiceImpl;
import com.blog.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.List;

@Controller
public class BlocController {
    @Autowired
    BlogServiceImpl blogService;

    @Autowired
    CategoryServiceImpl categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories() {
        return categoryService.findAllCategory();
    }

    @RequestMapping(value = "/blog", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Page<Blog> allBlog(@PageableDefault(page = 0, size = 2) Pageable pageable) {
        return blogService.findAll(pageable);
    }

    @GetMapping("")
    public String showHome(Model model, @PageableDefault(size = 2) Pageable pageable) {
        model.addAttribute("blogList", allBlog(pageable));
        return "blog/home";
    }

    @GetMapping(value = "/upload", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Page<Blog> uploadBlog(@RequestParam(value = "size") int size) {
        Pageable pageable = PageRequest.of(0, size);
        return blogService.findAll(pageable);
    }

    @GetMapping(value = "/search_name", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Blog> searchByName(@RequestParam(value = "nameBlog") String name) {
        return blogService.findByBlogNameContaining(name);
    }

    @GetMapping("search_category")
    public String searchByCategory(Model model, @RequestParam(name = "id") Integer id) {
        model.addAttribute("blogList", blogService.findByCategory(id));
        return "blog/search";
    }

    @GetMapping("create")
    public String showFormCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "blog/create";
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
        return "blog/edit";
    }

    @PostMapping("edit")
    public String editBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blog.setDateUpdate(new Date());
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "This blog edit successfully");
        return "redirect:/";
    }

    @GetMapping("delete/{id}")
    public String deleteBlog(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        blogService.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "This blog delete successfully");
        return "redirect:/";
    }

    @GetMapping("view/{id}")
    public String showBlog(@PathVariable Integer id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "blog/view";
    }
}
