package com.example.libraryprojectjava1.repository;

import com.example.libraryprojectjava1.pojo.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findByMemberId(Long memberId);
    List<Transaction> findByBookId(Long bookId);
}
