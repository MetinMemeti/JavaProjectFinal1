package com.example.libraryprojectjava1.service;

import com.example.libraryprojectjava1.pojo.dto.Address;
import com.example.libraryprojectjava1.pojo.entity.Member;
import com.example.libraryprojectjava1.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultMemberService implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Member create(Member user) {
        return memberRepository.save(user);
    }

    @Override
    public Optional<Member> findById(Integer id) {
        return memberRepository.findById(id);
    }

    @Override
    public List<Member> findByAddress(Address address) {
        // Assuming a custom repository method for finding members by address
        // Modify this if Address is a field in the Member entity
        return memberRepository.findByAddress(address);
    }

    @Override
    public void deleteUser(Integer id) {
        memberRepository.deleteById(id);
    }

    @Override
    public Member updateUser(Member memberToUpdate) {
        return memberRepository.save(memberToUpdate);
    }
}
