package com.example.libraryprojectjava1.repository;

import com.example.libraryprojectjava1.pojo.dto.Address;
import com.example.libraryprojectjava1.pojo.dto.LibraryType;
import com.example.libraryprojectjava1.pojo.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.*;

public interface LibraryRepository extends JpaRepository<Library, Integer> {
    List<Library> findByNameContaining(String name);
    @Query("SELECT l from Library l where l.address = :address")
    List<Library> findByAddress(@Param("address") Address address);

    @Query("SELECT l from Library l where l.type = :libraryType")
    List<Library> findByType(@Param("libraryType") LibraryType libraryType);

    @Query("SELECT l FROM Library l WHERE l.name LIKE %:name%")
    List<Library> findByName(@Param("name") String name);

    List<Library> findByAddressAndName(Address address, String name);

}
