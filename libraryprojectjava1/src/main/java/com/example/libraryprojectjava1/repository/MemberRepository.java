package com.example.libraryprojectjava1.repository;

import com.example.libraryprojectjava1.pojo.dto.Address;
import com.example.libraryprojectjava1.pojo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
//    // add member by id
//    //remove member by id or smth idk
//    Optional<Member> findByName(String name);
//    List<Member> findByTransactionsDueDateBefore(java.time.LocalDate dueDate); // Members with overdue transactions


    @Query("SELECT r from Member r where r.name = :name")
    List<Member> findByAddress(@Param("address") Address address);
}

