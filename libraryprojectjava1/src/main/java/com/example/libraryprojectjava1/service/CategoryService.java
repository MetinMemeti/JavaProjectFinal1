package com.example.libraryprojectjava1.service;

import com.example.libraryprojectjava1.pojo.entity.Category;

import java.util.*;

public interface CategoryService {
    Optional<Category> getCategoryByName(String name);
    Category saveCategory(Category category);
    Optional<Category> getCategoryById(Integer id);
}
