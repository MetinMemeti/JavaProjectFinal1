package com.example.libraryprojectjava1.pojo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "membershipDate")
    private LocalDate membershipDate;

    @ManyToOne
    @JoinColumn(name = "library_id", nullable = true)  // Now not nullable, to allow assignment later
    @JsonBackReference
    private Library library; // A member belongs to one library

    @OneToMany(mappedBy = "member")
    @JsonIgnore
    private Set<Transaction> transactions;

    public Member() {}

    public Member(Integer id, String name, String email, String phone, LocalDate membershipDate, Library library) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.membershipDate = membershipDate;
        this.library = library;
    }

    // Utility method to assign a member to a library
    public void assignToLibrary(Library library) {
        if (library == null) {
            throw new IllegalArgumentException("Library cannot be null");
        }
        this.library = library;
    }

    // Getter and Setter methods...

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getMembershipDate() {
        return membershipDate;
    }

    public void setMembershipDate(LocalDate membershipDate) {
        this.membershipDate = membershipDate;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(id, member.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
