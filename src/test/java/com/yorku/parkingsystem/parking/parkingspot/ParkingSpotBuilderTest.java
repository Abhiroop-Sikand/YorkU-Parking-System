package com.yorku.parkingsystem.parking.parkingspot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ParkingSpotBuilderTest {

    private ParkingSpotBuilder builder;

    @BeforeEach
    void setUp() {
        builder = new ParkingSpotBuilder();
    }

    @Test
    void testBuilder() {
        ParkingSpot parkingSpot = builder
                .setLocation("A1")
                .setAvailability(true)
                .build();
        assertNotNull(parkingSpot);
    }

    @Test
    void testSetLocation() {
        ParkingSpot parkingSpot = builder
                .setLocation("A1")
                .setAvailability(true)
                .build();
        assertEquals("A1", parkingSpot.getLocation());
    }



    @Test
    void testSetAvailability() {
        ParkingSpot parkingSpot = builder
                .setLocation("A1")
                .setAvailability(true)
                .build();
        assertTrue(parkingSpot.isAvailable());
    }

    @Test
    void testBuildWithLocationAndAvailability() {
        ParkingSpot parkingSpot = builder
                .setLocation("B2")
                .setAvailability(false)
                .build();
        assertEquals("B2", parkingSpot.getLocation());
        assertFalse(parkingSpot.isAvailable());
    }

    @Test
    void testBuildWithDefaultValues() {
        ParkingSpot parkingSpot = builder.build();
        assertNull(parkingSpot.getLocation());
        assertFalse(parkingSpot.isAvailable());
    }

    @Test
    void testSetLocationTwice() {
        ParkingSpot parkingSpot = builder
                .setLocation("C3")
                .setLocation("D4")
                .setAvailability(true)
                .build();
        assertNotEquals("C3", parkingSpot.getLocation());
        assertEquals("D4", parkingSpot.getLocation());
    }

    @Test
    void testSetAvailabilityTwice() {
        ParkingSpot parkingSpot = builder
                .setLocation("A1")
                .setAvailability(true)
                .setAvailability(false)
                .build();

        assertFalse(parkingSpot.isAvailable());
    }

    @Test
    void testSetLocationToNull() {
        ParkingSpot parkingSpot = builder
                .setLocation(null)
                .setAvailability(true)
                .build();
        assertNull(parkingSpot.getLocation());
    }

    @Test
    void testSetAvailabilityToTrue() {
        ParkingSpot parkingSpot = builder
                .setLocation("A1")
                .setAvailability(true)
                .build();
        assertTrue(parkingSpot.isAvailable());
    }

    @Test
    void testSetAvailabilityToFalse() {
        ParkingSpot parkingSpot = builder
                .setLocation("A1")
                .setAvailability(false)
                .build();
        assertFalse(parkingSpot.isAvailable());
    }

    @Test
    void testBuildWithEmptyLocation() {
        ParkingSpot parkingSpot = builder
                .setLocation("")
                .setAvailability(true)
                .build();
        assertEquals("", parkingSpot.getLocation());
    }

    @Test
    void testBuildWithLongLocation() {
        String longLocation = "Level 1, Zone A, Section 3, Row 5";
        ParkingSpot parkingSpot = builder
                .setLocation(longLocation)
                .setAvailability(true)
                .build();
        assertEquals(longLocation, parkingSpot.getLocation());
    }

    @Test
    void testBuildWithNumericLocation() {
        ParkingSpot parkingSpot = builder
                .setLocation("12345")
                .setAvailability(true)
                .build();
        assertEquals("12345", parkingSpot.getLocation());
    }


}