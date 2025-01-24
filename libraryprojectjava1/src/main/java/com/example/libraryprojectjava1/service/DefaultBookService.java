package com.example.libraryprojectjava1.service;

import com.example.libraryprojectjava1.pojo.entity.Book;
import com.example.libraryprojectjava1.pojo.entity.Category;
import com.example.libraryprojectjava1.repository.BookRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultBookService implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    // Add a new book
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    // Get all books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    // Get a book by ID
    public Book getBookById(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    // Update a book
    public Book updateBook(Integer id, Book bookDetails) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setCategory(bookDetails.getCategory());
            book.setAvailability(bookDetails.getAvailability());
            return bookRepository.save(book);
        }
        return null;
    }

    @Override
    // Delete a book
    public boolean deleteBook(Integer id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }
    @Override
    // Search books by title, author, or category
    public List<Book> searchBooks(String title, String author, Category category) {
        if (title != null && !title.isEmpty()) {
            return bookRepository.findByTitleContaining(title);
        } else if (author != null && !author.isEmpty()) {
            return bookRepository.findByAuthorContaining(author);
        } else if (category != null) {
            return bookRepository.findByCategory(category);
        }
        return bookRepository.findAll();
    }
}
