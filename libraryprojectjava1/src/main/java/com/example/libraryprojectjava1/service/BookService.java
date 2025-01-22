package com.example.libraryprojectjava1.service;

import com.example.libraryprojectjava1.pojo.Book;
import com.example.libraryprojectjava1.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Add a new book
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    // Get all books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Get a book by ID
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    // Update a book
    public Book updateBook(Long id, Book bookDetails) {
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

    // Delete a book
    public boolean deleteBook(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Search books by title, author, or category
    public List<Book> searchBooks(String title, String author, String category) {
        if (title != null && !title.isEmpty()) {
            return bookRepository.findByTitleContaining(title);
        } else if (author != null && !author.isEmpty()) {
            return bookRepository.findByAuthorContaining(author);
        } else if (category != null && !category.isEmpty()) {
            return bookRepository.findByCategory(category);
        }
        return bookRepository.findAll();
    }
}
