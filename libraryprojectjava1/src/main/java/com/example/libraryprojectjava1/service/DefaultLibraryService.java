package com.example.libraryprojectjava1.service;

import com.example.libraryprojectjava1.pojo.dto.Address;
import com.example.libraryprojectjava1.pojo.dto.LibraryType;
import com.example.libraryprojectjava1.pojo.entity.Library;
import com.example.libraryprojectjava1.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DefaultLibraryService implements LibraryService {

    @Autowired
    LibraryRepository libraryRepository;

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
        List<Library> libraries=new ArrayList<>();
        libraryRepository.findAll().forEach(libraries::add);
        return libraries;
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
    public void deleteLibrary(Integer id) {

         libraryRepository.deleteById(id);
    }

    @Override
    public Library update(Library libraryToUpdate) {
        return libraryRepository.save(libraryToUpdate);
    }

    @Override
    public List<Library> findByAddressAndName(Address address, String name) {
        return libraryRepository.findByAddressAndName(address,name);
    }
}
