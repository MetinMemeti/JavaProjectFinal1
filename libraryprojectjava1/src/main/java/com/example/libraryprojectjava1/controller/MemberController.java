package com.example.libraryprojectjava1.controller;

import com.example.libraryprojectjava1.pojo.entity.Member;
import com.example.libraryprojectjava1.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    // Create a new member
    @PostMapping
    public ResponseEntity<Member> create(@RequestBody Member member) {
        Member createdMember = memberService.create(member);
        return ResponseEntity.ok(createdMember);
    }

    // Get all members
    @GetMapping
    public ResponseEntity<List<Member>> findAll() {
        List<Member> members = memberService.findAll();
        return ResponseEntity.ok(members);
    }

    // Get a member by ID
    @GetMapping("/{id}")
    public ResponseEntity<Member> findById(@PathVariable Integer id) {
        Optional<Member> member = memberService.findById(id);
        return member.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get members by library ID
    @GetMapping("/library/{libraryId}")
    public ResponseEntity<List<Member>> findByLibrary(@PathVariable Integer libraryId) {
        List<Member> members = memberService.findByLibrary(libraryId);
        return ResponseEntity.ok(members);
    }

    // Update an existing member
    @PutMapping("/{id}")
    public ResponseEntity<Member> update(@PathVariable Integer id, @RequestBody Member member) {
        member.setId(id);  // Set the ID of the member to be updated
        Member updatedMember = memberService.update(member);
        return ResponseEntity.ok(updatedMember);
    }

    // Delete a member by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        memberService.deleteMember(id);
        return ResponseEntity.noContent().build();
    }

    // New method to assign a member to a library
    @PutMapping("/{memberId}/assign/{libraryId}")
    public ResponseEntity<Member> assignMemberToLibrary(
            @PathVariable Integer memberId,
            @PathVariable Integer libraryId) {
        try {
            Member updatedMember = memberService.assignMemberToLibrary(memberId, libraryId);
            return ResponseEntity.ok(updatedMember);  // Return the updated member with the assigned library
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);  // Return 400 if the member or library doesn't exist
        }
    }
}
