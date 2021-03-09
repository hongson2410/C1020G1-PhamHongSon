package com.blog.controllers;

import com.blog.models.Blog;
import com.blog.service.impl.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogRestController {
    @Autowired
    BlogServiceImpl blogService;

    @RequestMapping(value = "/blog_list", method = RequestMethod.GET)
    public ResponseEntity<List<Blog>> listBlog() {
        List<Blog> blogList = blogService.findAllBlog();
        if (blogList.isEmpty()) {
            return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Blog>>(blogList, HttpStatus.OK);
    }

    @RequestMapping(value = "/blog_list/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Blog> viewBlog(@PathVariable("id") Integer id) {
        Blog blog = blogService.findBlogById(id);
        if (blog == null) {
            return new ResponseEntity<Blog>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Blog>(blog, HttpStatus.OK);
    }

}
