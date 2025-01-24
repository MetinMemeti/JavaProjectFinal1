package com.example.libraryprojectjava1.service;

import com.example.libraryprojectjava1.pojo.entity.Book;
import com.example.libraryprojectjava1.pojo.entity.Category;

import java.util.List;

public interface BookService {
    public Book addBook(Book book);
    public List<Book> getAllBooks();
    public Book getBookById(Integer id);
    public Book updateBook(Integer id, Book bookDetails);
    public boolean deleteBook(Integer id);
    public List<Book> searchBooks(String title, String author, Category category);
    }
