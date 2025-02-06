package com.example.libraryprojectjava1.repository;

import com.example.libraryprojectjava1.pojo.entity.Book;
import com.example.libraryprojectjava1.pojo.entity.Category;
import com.example.libraryprojectjava1.pojo.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByTitleContaining(String title);
    List<Book> findByAuthorContaining(String author);
    List<Book> findByCategory(Category category);

    //add by id
    //remove by id
}
