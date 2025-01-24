package com.example.libraryprojectjava1.service;

import com.example.libraryprojectjava1.pojo.dto.Address;
import com.example.libraryprojectjava1.pojo.entity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    Member create(Member user);
    Optional<Member> findById(Integer id);
    List<Member> findByAddress(Address address);
    void deleteUser(Integer Uid);

    Member updateUser(Member userToUpdate);
}
