package com.example.libraryprojectjava1.repository;

import com.example.libraryprojectjava1.pojo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findByName(String name);
    List<Category> findByBooksIsEmpty(); // No books assigned to this category
    Long countById(Long categoryId); // Number of categories with this ID
}

