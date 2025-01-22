package com.example.libraryprojectjava1.repository;

import com.example.libraryprojectjava1.pojo.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    // Add custom query methods if needed
}
