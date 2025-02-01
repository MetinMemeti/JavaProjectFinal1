package com.example.libraryprojectjava1.service;

import com.example.libraryprojectjava1.pojo.dto.Address;
import com.example.libraryprojectjava1.pojo.dto.LibraryType;
import com.example.libraryprojectjava1.pojo.entity.Library;
import com.example.libraryprojectjava1.pojo.entity.Member;
import com.example.libraryprojectjava1.repository.LibraryRepository;
import com.example.libraryprojectjava1.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultLibraryService implements LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Library create(Library library) {
        return libraryRepository.save(library);
    }

    @Override
    public Optional<Library> findById(Integer id) {
        return libraryRepository.findById(id);
    }

    @Override
    public List<Library> findAll() {
        return libraryRepository.findAll();
    }

    @Override
    public List<Library> findByAddress(Address address) {
        return libraryRepository.findByAddress(address);
    }

    @Override
    public List<Library> findByType(LibraryType libraryType) {
        return libraryRepository.findByType(libraryType);
    }

    @Override
    public List<Library> findByName(String name) {
        return libraryRepository.findByName(name);
    }

    @Override
    public List<Member> getMembers(Integer libraryId) {
        return memberRepository.findByLibraryId(libraryId);  // Fetch members by library ID
    }

    @Override
    public void deleteLibrary(Integer id) {
        libraryRepository.deleteById(id);
    }

    @Override
    public Library update(Library libraryToUpdate) {
        return libraryRepository.save(libraryToUpdate);
    }

    @Override
    public List<Library> findByAddressAndName(Address address, String name) {
        return libraryRepository.findByAddressAndName(address, name);
    }
}
