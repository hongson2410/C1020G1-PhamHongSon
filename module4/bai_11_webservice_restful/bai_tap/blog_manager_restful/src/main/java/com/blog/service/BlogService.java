package com.blog.service;

import com.blog.models.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAllBlog();

    Blog findBlogById(int id);

    List<Blog> findByCategoryId(int id);
}
