package com.blog.service;

import com.blog.model.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();
    Blog findById(int id);
    void save(Blog blog);
    void deleteById(int id);
}
