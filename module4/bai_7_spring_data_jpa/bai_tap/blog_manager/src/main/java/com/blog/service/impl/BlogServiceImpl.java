package com.blog.service.impl;

import com.blog.model.Blog;
import com.blog.repository.BlogRepository;
import com.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    public Page<Blog> findByBlogNameContaining(Pageable pageable, String blogName) {
        return blogRepository.findByBlogNameContaining(pageable, blogName);
    }

    @Override
    public Page<Blog> findByCategory(Pageable pageable, int categoryId) {
        return blogRepository.findByCategoryId(pageable, categoryId);
    }
}
