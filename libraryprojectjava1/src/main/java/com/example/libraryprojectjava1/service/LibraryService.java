package com.example.libraryprojectjava1.service;

import com.example.libraryprojectjava1.pojo.dto.Address;
import com.example.libraryprojectjava1.pojo.dto.LibraryType;
import com.example.libraryprojectjava1.pojo.entity.Library;

import java.util.List;
import java.util.Optional;

public interface LibraryService {

    Library create(Library library);
    Optional<Library> findById(Integer id);
    List<Library> findAll();
    List<Library> findByAddress(Address address);
    List<Library> findByType(LibraryType libraryType);
    List<Library> findByName(String name);

    void deleteLibrary(Integer id);

    Library update(Library libraryToUpdate);

    List<Library> findByAddressAndName(Address address, String name);
}
