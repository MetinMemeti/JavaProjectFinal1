package com.example.libraryprojectjava1.pojo.entity;

import com.example.libraryprojectjava1.pojo.Address;
import com.example.libraryprojectjava1.pojo.AvailabilityL;
import com.example.libraryprojectjava1.pojo.LibraryType;
import com.example.libraryprojectjava1.pojo.LoanFrequency;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "library")
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, unique = true)
    private String name; // Name of the library

    @Column(name = "address", nullable = false)
    private Address address; // Address of the library

    @Column(name = "type")
    private LibraryType type;// Type of library (e.g., public, private, academic)

    private double rating;

    @Column(name = "availability")
    private AvailabilityL isOpenToPublic; // Whether the library is open to the public

    @Column(name = "latitude")
    private double latitude; // Geographic latitude of the library

    @Column(name = "longitude")
    private double longitude; // Geographic longitude of the library

    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Member> members; // A library can have multiple members

    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Book> books = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "library_ratings", joinColumns = @JoinColumn(name = "library_id"))
    @Column(name = "rating")
    @JsonIgnore
    private List<Integer> ratings = new ArrayList<>(); // List of ratings for the library


    @Column(name = "average_rating")
    @JsonIgnore
    private double averageRating; // Average rating of the library


    @Transient
    private double distance;

    @Column(name = "total_loans")
    private int totalLoans; // Total number of books borrowed from the library

    @Column(name = "loan_frequency")
    @Enumerated(EnumType.STRING)
    private LoanFrequency loanFrequency; // Categorization based on book borrow rate

    @Column(name = "total_members")
    private int totalMembers; // Total registered library members


    public Library(Integer id, String name, Address address, LibraryType type, AvailabilityL isOpenToPublic, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.type = type;
        this.rating=0.0;
        this.isOpenToPublic = isOpenToPublic;
        this.latitude = latitude;
        this.longitude = longitude;
        this.ratings=new ArrayList<>();
        this.members=new HashSet<>();
        this.books=new HashSet<>();
        this.averageRating=0.0;
        this.distance=0.0;
        this.loanFrequency = LoanFrequency.LOW; // Default value
    }

    public Library() {
    }

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public LibraryType getType() {
        return type;
    }

    public void setType(LibraryType type) {
        this.type = type;
    }

    public AvailabilityL getIsOpenToPublic() {
        return isOpenToPublic;
    }

    public void setIsOpenToPublic(AvailabilityL isOpenToPublic) {
        this.isOpenToPublic = isOpenToPublic;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Set<Member> getMembers() {
        return members;
    }

    public void setMembers(Set<Member> members) {
        this.members = members;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public int getTotalLoans() {
        return totalLoans;
    }
    public void setTotalLoans(int totalLoans) {
        this.totalLoans = totalLoans;
    }

    public int getTotalMembers() {
        return totalMembers;
    }

    public void setTotalMembers(int totalMembers) {
        this.totalMembers = totalMembers;
    }

    public List<Integer> getRatings() {
        return ratings;
    }
    public void setRatings(List<Integer> ratings) {
        this.ratings = ratings;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
    public double getRating() {
        return rating;
    }
    public double getAverageRating() {
        return averageRating;
    }
    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        distance = Math.round(distance * 100) / 100.0;
        this.distance = distance;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }
    public void addRating(int rating){
        this.ratings.add(rating);
        totalRating();
    }

//    public void totalRating(){
//        double Sum = 0;
//        for (Integer rating:ratings){
//            Sum += rating;
//        }
//
//        double rate = Sum / ratings.size();
//        setRating(rate);
//    }
    public void totalRating() {
        if (ratings.isEmpty()) {
            setRating(0);
            return;
        }
        double sum = ratings.stream().mapToDouble(Integer::doubleValue).sum();
        setRating(sum / ratings.size());
    }


    public static double distance(double latitude, double longitude, double latitude2, double longitude2){

        double theta = longitude - longitude2;

        double dist = Math.sin(deg2rad(latitude)) * Math.sin(deg2rad(latitude2)) +
                Math.cos(deg2rad(latitude)) * Math.cos(deg2rad(latitude2)) * Math.cos(deg2rad(theta));

        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 *1.1515;
        dist = dist * 1609.34;
        return (dist);
    }

    private static double deg2rad(double degree){
        return (degree * Math.PI / 180.0);
    }

    private static double rad2deg(double radian) {
        return (radian * 180 / Math.PI);
    }

    public void setLoanFrequency(LoanFrequency loanFrequency) {
        this.loanFrequency = loanFrequency;
    }

    public LoanFrequency getLoanFrequency() {
        return loanFrequency;
    }

    public void incrementLoanCount() {
        this.totalLoans++;
        updateLoanFrequency();
    }

    private void updateLoanFrequency() {
        if (totalLoans < 100) {
            this.loanFrequency = LoanFrequency.LOW;
        } else if (totalLoans >= 100 && totalLoans < 500) {
            this.loanFrequency = LoanFrequency.MODERATE;
        } else {
            this.loanFrequency = LoanFrequency.HIGH;
        }
    }

    public void addMember() {
        this.totalMembers++;
    }

    public void removeMember() {
        if (this.totalMembers > 0) {
            this.totalMembers--;
        }
    }

}
