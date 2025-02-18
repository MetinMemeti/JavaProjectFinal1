package com.example.libraryprojectjava1.controller;

import com.example.libraryprojectjava1.pojo.enums.Address;
import com.example.libraryprojectjava1.pojo.enums.LibraryType;
import com.example.libraryprojectjava1.pojo.entity.Library;
import com.example.libraryprojectjava1.pojo.entity.Member;
import com.example.libraryprojectjava1.service.LibraryService;
import com.example.libraryprojectjava1.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/libraries")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @Autowired
    private MemberService memberService;

    // Create a new library
    @PostMapping
    public ResponseEntity<Library> createLibrary(@RequestBody Library library) {
        Library createdLibrary = libraryService.create(library);
        return ResponseEntity.ok(createdLibrary);
    }

    // Get all libraries
    @GetMapping
    public ResponseEntity<List<Library>> getAllLibraries() {
        List<Library> libraries = libraryService.findAll();
        return ResponseEntity.ok(libraries);
    }

    // Get a library by ID2
    @GetMapping("/{id}")
    public ResponseEntity<Library> getLibraryById(@PathVariable Integer id) {
        Optional<Library> library = libraryService.findById(id);
        return library.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a library
    @PutMapping("/{id}")
    public ResponseEntity<Library> updateLibrary(@PathVariable Integer id, @RequestBody Library libraryDetails) {
        Optional<Library> existingLibrary = libraryService.findById(id);
        if (existingLibrary.isPresent()) {
            libraryDetails.setId(id);  // Ensure the library ID is preserved during update
            Library updatedLibrary = libraryService.update(libraryDetails);
            return ResponseEntity.ok(updatedLibrary);
        }
        return ResponseEntity.notFound().build();
    }

    // Delete a library
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibrary(@PathVariable Integer id) {
        Optional<Library> existingLibrary = libraryService.findById(id);
        if (existingLibrary.isPresent()) {
            libraryService.deleteLibrary(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Find libraries by address
    @GetMapping("/search/address")
    public ResponseEntity<List<Library>> findLibrariesByAddress(@RequestParam Address address) {
        List<Library> libraries = libraryService.findByAddress(address);
        return ResponseEntity.ok(libraries);
    }

    // Find libraries by type
    @GetMapping("/search/type")
    public ResponseEntity<List<Library>> findLibrariesByType(@RequestParam LibraryType libraryType) {
        List<Library> libraries = libraryService.findByType(libraryType);
        return ResponseEntity.ok(libraries);
    }

    // Find libraries by name
    @GetMapping("/search/name")
    public ResponseEntity<List<Library>> findLibrariesByName(@RequestParam String name) {
        List<Library> libraries = libraryService.findByName(name);
        return ResponseEntity.ok(libraries);
    }

    // Find libraries by both address and name
    @GetMapping("/search/addressAndName")
    public ResponseEntity<List<Library>> findLibrariesByAddressAndName(@RequestParam Address address, @RequestParam String name) {
        List<Library> libraries = libraryService.findByAddressAndName(address, name);
        return ResponseEntity.ok(libraries);
    }

    // New: Get members of a specific library
    @GetMapping("/{libraryId}/members")
    public ResponseEntity<List<Member>> getMembers(@PathVariable Integer libraryId) {
        List<Member> members = libraryService.getMembers(libraryId);
        return ResponseEntity.ok(members);
    }

    // New: Add a member to a library
    @PostMapping("/{libraryId}/members")
    public ResponseEntity<Member> addMemberToLibrary(@PathVariable Integer libraryId, @RequestBody Member member) {
        Library library = libraryService.findById(libraryId).orElseThrow(() -> new RuntimeException("Library not found"));
        member.setLibrary(library);
        Member savedMember = memberService.create(member);
        return ResponseEntity.ok(savedMember);
    }
}
