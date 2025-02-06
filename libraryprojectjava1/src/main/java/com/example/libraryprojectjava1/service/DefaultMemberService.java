package com.example.libraryprojectjava1.service;

import com.example.libraryprojectjava1.pojo.entity.Member;
import com.example.libraryprojectjava1.pojo.entity.Library;
import com.example.libraryprojectjava1.repository.MemberRepository;
import com.example.libraryprojectjava1.repository.LibraryRepository;  // Import LibraryRepository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultMemberService implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private LibraryRepository libraryRepository;  // Inject LibraryRepository

    @Override
    public Member create(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Optional<Member> findById(Integer id) {
        return memberRepository.findById(id);
    }

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public List<Member> findByLibrary(Integer libraryId) {
        return memberRepository.findByLibraryId(libraryId);  // Fetch members by library ID
    }

    @Override
    public void deleteMember(Integer id) {
        memberRepository.deleteById(id);
    }

    @Override
    public Member update(Member member) {
        return memberRepository.save(member);
    }

    // New method to assign a member to a library
    @Override
    public Member assignMemberToLibrary(Integer memberId, Integer libraryId) {
        Optional<Member> memberOpt = memberRepository.findById(memberId);
        Optional<Library> libraryOpt = libraryRepository.findById(libraryId);

        if (memberOpt.isPresent() && libraryOpt.isPresent()) {
            Member member = memberOpt.get();
            Library library = libraryOpt.get();

            member.setLibrary(library); // Assign the library to the member
            return memberRepository.save(member); // Save the updated member
        } else {
            throw new IllegalArgumentException("Invalid member or library ID");
        }
    }
}
