package com.example.libraryprojectjava1.testings;


import com.example.libraryprojectjava1.pojo.Address;
import com.example.libraryprojectjava1.pojo.AvailabilityL;
import com.example.libraryprojectjava1.pojo.LibraryType;
import com.example.libraryprojectjava1.pojo.LoanFrequency;
import com.example.libraryprojectjava1.pojo.entity.Library;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LibraryTest {

    private Library library;

    @BeforeEach
    void setUp() {
        Address address = Address.OHRID;
        library = new Library(1, "Central Library", address, LibraryType.PUBLIC, AvailabilityL.OPENED, 40.7128, -74.0060);
    }

//    @Test
//    void testAddRating() {
//        library.addRating(5);
//        library.addRating(3);
//        library.addRating(4);
//
//        assertEquals(List.of(5, 3, 4), library.getRatings(), "Ratings should match");
//    }

    @Test
    void testTotalRating() {
        library.addRating(5);
        library.addRating(4);
        library.addRating(3);

        library.totalRating();

        assertEquals(4.0, library.getRating(), 0.01, "Average rating should be 4.0");
    }

    @Test
    void testTotalRatingWhenNoRatings() {
        library.totalRating();
        assertEquals(0.0, library.getRating(), "Rating should be 0 when no ratings are present");
    }

    @Test
    void testIncrementLoanCount() {
        library.incrementLoanCount();
        library.incrementLoanCount();

        assertEquals(2, library.getTotalLoans(), "Total loans should be 2");
    }

    @Test
    void testLoanFrequencyUpdate() {
        for (int i = 0; i < 50; i++) {
            library.incrementLoanCount();
        }
        assertEquals(LoanFrequency.LOW, library.getLoanFrequency(), "Loan frequency should be LOW");

        for (int i = 0; i < 60; i++) {
            library.incrementLoanCount();
        }
        assertEquals(LoanFrequency.MODERATE, library.getLoanFrequency(), "Loan frequency should be MODERATE");

        for (int i = 0; i < 450; i++) {
            library.incrementLoanCount();
        }
        assertEquals(LoanFrequency.HIGH, library.getLoanFrequency(), "Loan frequency should be HIGH");
    }

    @Test
    void testAddMember() {
        library.addMember();
        library.addMember();

        assertEquals(2, library.getTotalMembers(), "Total members should be 2");
    }

    @Test
    void testRemoveMember() {
        library.addMember();
        library.addMember();
        library.removeMember();

        assertEquals(1, library.getTotalMembers(), "Total members should be 1 after removing a member");
    }

    @Test
    void testRemoveMemberWhenNone() {
        library.removeMember();
        assertEquals(0, library.getTotalMembers(), "Total members should stay at 0 when removing from an empty list");
    }


    @Test
    void testDistanceCalculation() {
        double lat2 = 34.0522;  // Los Angeles, CA
        double lon2 = -118.2437;

        double result = Library.distance(library.getLatitude(), library.getLongitude(), lat2, lon2);
        double expectedMin = 3900000; // Roughly 3,900 km in meters
        double expectedMax = 4100000;

        assertTrue(result > expectedMin && result < expectedMax, "Distance should be within expected range.");
    }


}
