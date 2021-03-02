package com.blog.controller;

import com.blog.model.Blog;
import com.blog.service.impl.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {
    @Autowired
    BlogServiceImpl blogService;

    @GetMapping("/")
    public String showHome(Model model) {
        model.addAttribute("blogList", blogService.findAll());
        return "home";
    }

    @GetMapping("create")
    public String showFormCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("create")
    public String createBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
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
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "New blog edit successfully");
        return "redirect:/";
    }

    @GetMapping("delete/{id}")
    public ModelAndView showFormDelete(@PathVariable Integer id){
        Blog blog = blogService.findById(id);
        if(blog != null) {
            ModelAndView modelAndView = new ModelAndView("delete");
            modelAndView.addObject("blog", blog);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("delete")
    public String deleteBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        blogService.deleteById(blog.getId());
        redirectAttributes.addFlashAttribute("message","New blog delete successfully");
        return "redirect:/";
    }

    @GetMapping("view/{id}")
    public String showBlog(@PathVariable Integer id, Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "view";
    }
}
