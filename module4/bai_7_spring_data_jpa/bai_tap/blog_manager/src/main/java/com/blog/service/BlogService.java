package com.blog.service;

import com.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable);
    Blog findById(int id);
    void save(Blog blog);
    void deleteById(int id);
    Page<Blog> findByBlogNameContaining(Pageable pageable, String blogName);
    Page<Blog> findByCategory(Pageable pageable, int categoryId);
}
