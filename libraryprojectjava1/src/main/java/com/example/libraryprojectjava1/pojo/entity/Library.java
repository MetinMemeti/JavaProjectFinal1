package com.example.libraryprojectjava1.pojo.entity;

import com.example.libraryprojectjava1.pojo.dto.Address;
import com.example.libraryprojectjava1.pojo.dto.AvailabilityL;
import com.example.libraryprojectjava1.pojo.dto.LibraryType;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "library")
public class Library {

    @GeneratedValue
    @Id
    private Integer id;

    @Column(name = "name", nullable = false, unique = true)
    private String name; // Name of the library

    @Column(name = "address", nullable = false)
    private Address address; // Address of the library

    @Column(name = "type")
    private LibraryType type; // Type of library (e.g., public, private, academic)

    @Column(name = "availability")
    private AvailabilityL isOpenToPublic; // Whether the library is open to the public

    @Column(name = "latitude")
    private double latitude; // Geographic latitude of the library

    @Column(name = "longitude")
    private double longitude; // Geographic longitude of the library

    @OneToMany(mappedBy = "library")
    private Set<Member> members; // A library can have multiple members

    public Library(Integer id, String name, Address address, LibraryType type, AvailabilityL isOpenToPublic, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.type = type;
        this.isOpenToPublic = isOpenToPublic;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Library() {
    }

    // Getter and Setter methods...

    public Set<Member> getMembers() {
        return members;
    }

    public void setMembers(Set<Member> members) {
        this.members = members;
    }
}
