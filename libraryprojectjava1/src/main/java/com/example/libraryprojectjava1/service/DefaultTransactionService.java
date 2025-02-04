package com.example.libraryprojectjava1.service;

import com.example.libraryprojectjava1.pojo.entity.Transaction;
import com.example.libraryprojectjava1.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultTransactionService implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<Transaction> getTransactionsByMember(Integer memberId) {
        return transactionRepository.findByMemberId(memberId);
    }

    @Override
    public List<Transaction> getTransactionsByBook(Integer bookId) {
        return transactionRepository.findByBookId(bookId);
    }

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        // Check if the book is already borrowed by another member
        List<Transaction> existingTransactions = transactionRepository.findByBookId(transaction.getBook().getId());
        for (Transaction existingTransaction : existingTransactions) {
            if (existingTransaction.getStatus() == Transaction.Status.BORROWED) {
                throw new IllegalArgumentException("The book is already borrowed by another member.");
            }
        }

        // Save the new transaction
        return transactionRepository.save(transaction);
    }

    @Override
    public Optional<Transaction> getTransactionById(Integer id) {
        return transactionRepository.findById(id);
    }

    @Override
    public Transaction updateTransaction(Transaction transaction) {
        if (transaction.getId() == null) {
            throw new IllegalArgumentException("Transaction ID is required for updating.");
        }

        Optional<Transaction> existingTransactionOpt = transactionRepository.findById(transaction.getId());
        if (existingTransactionOpt.isEmpty()) {
            throw new IllegalArgumentException("Transaction not found.");
        }

        Transaction existingTransaction = existingTransactionOpt.get();

        // Validate that the book reference is not null
        if (transaction.getBook() == null) {
            throw new IllegalArgumentException("Book cannot be null when updating a transaction.");
        }

        // Update fields
        existingTransaction.setBook(transaction.getBook());
        existingTransaction.setMember(transaction.getMember());
        existingTransaction.setBorrowDate(transaction.getBorrowDate());
        existingTransaction.setReturnDate(transaction.getReturnDate());
        existingTransaction.setStatus(transaction.getStatus());

        return transactionRepository.save(existingTransaction);
    }
}
