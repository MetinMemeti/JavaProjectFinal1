package com.example.libraryprojectjava1.repository;

import com.example.libraryprojectjava1.pojo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
    Optional<Member> findByEmail(String email);
    List<Member> findByLibraryId(Integer libraryId);
}
