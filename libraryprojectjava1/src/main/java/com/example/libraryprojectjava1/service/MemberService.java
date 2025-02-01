package com.example.libraryprojectjava1.service;

import com.example.libraryprojectjava1.pojo.entity.Member;
import java.util.List;
import java.util.Optional;

public interface MemberService {

    Member create(Member member);
    Optional<Member> findById(Integer id);
    List<Member> findAll();
    List<Member> findByLibrary(Integer libraryId);  // Get members by library ID



    void deleteMember(Integer id);

    Member update(Member member);

    // New method to assign a member to a library
    Member assignMemberToLibrary(Integer memberId, Integer libraryId);
}
