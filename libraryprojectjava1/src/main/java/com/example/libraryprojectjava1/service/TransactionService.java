package com.example.libraryprojectjava1.service;

import com.example.libraryprojectjava1.pojo.entity.Transaction;

import java.util.*;

public interface TransactionService {
    List<Transaction> getTransactionsByMember(Long memberId);
    List<Transaction> getTransactionsByBook(Long bookId);
    Transaction saveTransaction(Transaction transaction);
    Optional<Transaction> getTransactionById(Long id);
}
