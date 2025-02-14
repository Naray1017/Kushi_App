package com.example.web_login.controller;


import com.example.web_login.entity.Bookings;
import com.example.web_login.service.BookingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api") // Standardizing the endpoint
@CrossOrigin(origins = "http://localhost:3000") // Update if needed
public class BookingsController {

    @Autowired
    private BookingsService bookingsService;

    // Get all bookings
    @GetMapping("/bookings")
    public ResponseEntity<List<Bookings>> getAllBookings() {
        return ResponseEntity.ok(bookingsService.getAllBookings());
    }

    // Get new bookings (Pending status)
    @GetMapping("/pending")
    public ResponseEntity<List<Bookings>> getPendingBookings() {
        return ResponseEntity.ok(bookingsService.getPendingBookings());
    }

    // Get confirmed bookings
    @GetMapping("/confirmed")
    public ResponseEntity<List<Bookings>> getConfirmedBookings() {
        return ResponseEntity.ok(bookingsService.getConfirmedBookings());
    }

    // Get completed bookings
    @GetMapping("/completed")
    public ResponseEntity<List<Bookings>> getCompletedBookings() {
        return ResponseEntity.ok(bookingsService.getCompletedBookings());
    }

    // Confirm a booking
    @PutMapping("/confirm/{bookingId}")
    public ResponseEntity<String> confirmBooking(@PathVariable Long bookingId) {
        String response = bookingsService.confirmBooking(bookingId);

        if (response.equals("Booking not found")) {
            return ResponseEntity.status(404).body("Booking not found");
        }

        return ResponseEntity.ok(response);
    }
}