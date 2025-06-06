package com.yorku.parkingsystem.parking.parkingspot;

import com.yorku.parkingsystem.parking.ParkingComponent;
import com.yorku.parkingsystem.parking.parkinglot.ParkingLot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ParkingSpotTest {

    private ParkingSpot parkingSpot;

    @BeforeEach
    void setUp() {
        ParkingSpot.resetIDCounter();
        parkingSpot = new ParkingSpot();
    }

    @Test
    void testParkingSpotIDGeneration() {
        assertEquals(1, parkingSpot.getParkingSpotID(), "Parking spot ID should be 1");
        ParkingSpot parkingSpot2 = new ParkingSpot();
        assertEquals(2, parkingSpot2.getParkingSpotID(), "Parking spot ID should be 2");
        assertNotEquals(parkingSpot.getParkingSpotID(), parkingSpot2.getParkingSpotID(), "IDs should be unique");
    }

    @Test
    void testSetAndGetLocation() {
        parkingSpot.setLocation("A1");
        assertEquals("A1", parkingSpot.getLocation(), "Location should be A1");
        parkingSpot.setLocation("B2");
        assertEquals("B2", parkingSpot.getLocation(), "Location should be B2");
    }

    @Test
    void testSetAndGetAvailability() {
        parkingSpot.setAvailability(true);
        assertTrue(parkingSpot.isAvailable(), "Parking spot should be available");
        parkingSpot.setAvailability(false);
        assertFalse(parkingSpot.isAvailable(), "Parking spot should not be available");
    }

    @Test
    void testSetAndGetBelongedToParkingLot() {
        parkingSpot.setBelongedToParkingLot(true);
        assertTrue(parkingSpot.isBelongedToParkingLot(), "Parking spot should belong to a parking lot");
        parkingSpot.setBelongedToParkingLot(false);
        assertFalse(parkingSpot.isBelongedToParkingLot(), "Parking spot should not belong to a parking lot");
    }

    @Test
    void testSetAndGetEnabled() {
        parkingSpot.setEnabled(true);
        assertTrue(parkingSpot.isEnabled(), "Parking spot should be enabled");
        parkingSpot.setEnabled(false);
        assertFalse(parkingSpot.isEnabled(), "Parking spot should be disabled");
    }

    @Test
    void testShotDetails() {
        parkingSpot.setLocation("A1");
        parkingSpot.setAvailability(true);
        parkingSpot.setBelongedToParkingLot(true);
        parkingSpot.shotDetails();
        assertEquals("A1", parkingSpot.getLocation(), "Location should be A1");
        assertTrue(parkingSpot.isAvailable(), "Parking spot should be available");
        assertTrue(parkingSpot.isBelongedToParkingLot(), "Parking spot should belong to a parking lot");
    }

    @Test
    void testResetIDCounter() {
        ParkingSpot.resetIDCounter();
        assertEquals(0, ParkingSpot.getIdCounter(), "ID counter should be reset to 0");
        ParkingSpot parkingSpot1 = new ParkingSpot();
        assertEquals(1, parkingSpot1.getParkingSpotID(), "ID counter should be reset to 1");
        ParkingSpot parkingSpot2 = new ParkingSpot();
        assertEquals(2, parkingSpot2.getParkingSpotID(), "ID counter should increment correctly");
    }

    @Test
    void testMultipleParkingSpots() {
        // Add more parking spots
        ParkingSpot parkingSpot2 = new ParkingSpot();
        assertEquals(1, parkingSpot.getParkingSpotID(), "First parking spot ID should be 1");
        assertEquals(2, parkingSpot2.getParkingSpotID(), "Second parking spot ID should be 2");
        assertNotEquals(parkingSpot.getParkingSpotID(), parkingSpot2.getParkingSpotID(), "IDs should be unique");
    }

    @Test
    void testSetAndGetLocationNull() {
        parkingSpot.setLocation(null);
        assertNull(parkingSpot.getLocation(), "Location should be null");
        parkingSpot.setLocation("A1");
        assertNotNull(parkingSpot.getLocation(), "Location should not be null");
    }

    @Test
    void testSetAndGetAvailabilityDefault() {
        assertFalse(parkingSpot.isAvailable(), "Default availability should be false");
        parkingSpot.setAvailability(true);
        assertTrue(parkingSpot.isAvailable(), "Availability should be true");
    }
    @Test
    void testSetAndGetParkingLot() {
        ParkingLot parkingLot = new ParkingLot("Main Lot", "York University");
        parkingSpot.setParkingLot(parkingLot);
        assertEquals(parkingLot, parkingSpot.getParkingLot(), "Parking lot should be set correctly");
    }

    @Test
    void testSetAndGetParkingLotNull() {
        parkingSpot.setParkingLot(null);
        assertNull(parkingSpot.getParkingLot(), "Parking lot should be null");
    }




}