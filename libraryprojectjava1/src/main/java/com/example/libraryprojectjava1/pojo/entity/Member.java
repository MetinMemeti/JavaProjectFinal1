package com.example.libraryprojectjava1.pojo.entity;

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
    @JoinColumn(name = "library_id", nullable = false)
    private Library library; // A member belongs to one library

    @OneToMany(mappedBy = "member")
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

    // Getter and Setter methods...

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
