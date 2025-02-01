package com.example.libraryprojectjava1.service;

import com.example.libraryprojectjava1.pojo.entity.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionService {
    List<Transaction> getTransactionsByMember(Integer memberId);

    List<Transaction> getTransactionsByBook(Integer bookId);

    Transaction saveTransaction(Transaction transaction);

    Optional<Transaction> getTransactionById(Integer id);
}