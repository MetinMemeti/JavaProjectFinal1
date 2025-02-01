package com.example.libraryprojectjava1.controller;

import com.example.libraryprojectjava1.pojo.entity.Transaction;
import com.example.libraryprojectjava1.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    // Get all transactions by a specific member
    @GetMapping("/member/{memberId}")
    public ResponseEntity<List<Transaction>> getTransactionsByMember(@PathVariable Integer memberId) {
        List<Transaction> transactions = transactionService.getTransactionsByMember(memberId);
        return ResponseEntity.ok(transactions);
    }

    // Get all transactions by a specific book
    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<Transaction>> getTransactionsByBook(@PathVariable Integer bookId) {
        List<Transaction> transactions = transactionService.getTransactionsByBook(bookId);
        return ResponseEntity.ok(transactions);
    }

    // Create a new transaction
    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        try {
            Transaction savedTransaction = transactionService.saveTransaction(transaction);
            return ResponseEntity.ok(savedTransaction);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);  // Return 400 with a message
        }
    }

    // Get a specific transaction by ID
    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable Integer id) {
        Optional<Transaction> transaction = transactionService.getTransactionById(id);
        return transaction.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a transaction (e.g., changing the status)
    @PutMapping("/{id}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable Integer id, @RequestBody Transaction transaction) {
        transaction.setId(id);  // Set the ID of the transaction to be updated
        Transaction updatedTransaction = transactionService.saveTransaction(transaction); // Assuming save for update
        return ResponseEntity.ok(updatedTransaction);
    }
}
