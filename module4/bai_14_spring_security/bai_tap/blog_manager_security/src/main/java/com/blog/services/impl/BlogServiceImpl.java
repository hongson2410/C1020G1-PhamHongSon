package com.blog.services.impl;

import com.blog.models.Blog;
import com.blog.repositories.BlogRepository;
import com.blog.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findByOrderByDateUpdateDesc(pageable);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void deleteById(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public List<Blog> findByBlogNameContaining(String blogName) {
        return blogRepository.findByBlogNameContaining(blogName);
    }

    @Override
    public List<Blog> findByCategory(int categoryId) {
        return blogRepository.findByCategoryId(categoryId);
    }
}
