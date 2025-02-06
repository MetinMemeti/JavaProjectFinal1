package com.example.libraryprojectjava1.service;

import com.example.libraryprojectjava1.pojo.enums.Address;
import com.example.libraryprojectjava1.pojo.enums.LibraryType;
import com.example.libraryprojectjava1.pojo.entity.Library;
import com.example.libraryprojectjava1.pojo.entity.Member;

import java.util.List;
import java.util.Optional;

public interface LibraryService {

    Library create(Library library);
    Optional<Library> findById(Integer id);
    List<Library> findAll();
    List<Library> findByAddress(Address address);
    List<Library> findByType(LibraryType libraryType);
    List<Library> findByName(String name);
    List<Member> getMembers(Integer libraryId);

    void deleteLibrary(Integer id);

    Library update(Library libraryToUpdate);

    List<Library> findByAddressAndName(Address address, String name);
}
