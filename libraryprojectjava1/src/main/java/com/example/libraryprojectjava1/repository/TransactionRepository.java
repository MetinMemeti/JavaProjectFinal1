package com.example.libraryprojectjava1.repository;

import com.example.libraryprojectjava1.pojo.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // Add custom query methods if needed
}
