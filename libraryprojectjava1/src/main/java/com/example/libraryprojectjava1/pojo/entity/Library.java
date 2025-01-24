package com.example.libraryprojectjava1.pojo.entity;


import com.example.libraryprojectjava1.pojo.dto.Address;
import com.example.libraryprojectjava1.pojo.dto.AvailabilityL;
import com.example.libraryprojectjava1.pojo.dto.LibraryType;
import jakarta.persistence.*;

@Entity
@Table(name="library")
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
    @Column(name = "longtitude")
    private double longitude; // Geographic longitude of the library

    public Library(Integer  id, String name, Address address, LibraryType type, AvailabilityL isOpenToPublic, double latitude, double longitude) {
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

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    // Getter and Setter for 'name'
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for 'address'
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    // Getter and Setter for 'type'
    public LibraryType getType() {
        return type;
    }

    public void setType(LibraryType type) {
        this.type = type;
    }

    // Getter and Setter for 'isOpenToPublic'
    public AvailabilityL isOpenToPublic() {
        return isOpenToPublic;
    }

    public void setOpenToPublic(AvailabilityL isOpenToPublic) {
        this.isOpenToPublic = isOpenToPublic;
    }

    // Getter and Setter for 'latitude'
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    // Getter and Setter for 'longitude'
    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
