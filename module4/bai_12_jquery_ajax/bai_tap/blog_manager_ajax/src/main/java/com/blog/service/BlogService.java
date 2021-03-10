package com.blog.service;

import com.blog.models.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface BlogService {
    Page<Blog> findAll(Pageable pageable);

    Blog findById(int id);

    void save(Blog blog);

    void deleteById(int id);

    List<Blog> findByBlogNameContaining(String blogName);

    List<Blog> findByCategory(int categoryId);
}
