package com.blog.service;

import com.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    Page<Category> findAllCategory(Pageable pageable);
    Category findByIdCategory(int id);
    void saveCategory(Category category);
    void deleteByIdCategory(int id);
}
