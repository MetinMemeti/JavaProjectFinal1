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
            // Check if the transaction is still in the "BORROWED" status
            if (existingTransaction.getStatus() == Transaction.Status.BORROWED) {
                throw new IllegalArgumentException("The book is already borrowed by another member.");
            }
        }

        // If no such transaction exists, proceed to save the new transaction
        return transactionRepository.save(transaction);
    }

    @Override
    public Optional<Transaction> getTransactionById(Integer id) {
        return transactionRepository.findById(id);
    }
}
