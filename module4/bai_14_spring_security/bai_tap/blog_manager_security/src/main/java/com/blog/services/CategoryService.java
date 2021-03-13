package com.blog.services;

import com.blog.models.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAllCategory();

    Category findByIdCategory(int id);

    void saveCategory(Category category);

    void deleteByIdCategory(int id);
}
