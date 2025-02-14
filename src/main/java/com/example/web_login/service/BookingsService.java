package com.example.web_login.service;


import com.example.web_login.entity.Bookings;
import com.example.web_login.repo.BookingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingsService {
    @Autowired
    private BookingsRepository bookingRepository;

    // Get all bookings
    public List<Bookings> getAllBookings() {
        return bookingRepository.findAll();
    }

    // Get pending bookings (New Bookings)
    public List<Bookings> getPendingBookings() {
        return bookingRepository.findByBookingStatus("Pending");
    }

    // Get confirmed bookings
    public List<Bookings> getConfirmedBookings() {
        return bookingRepository.findByBookingStatus("Confirmed");
    }

    // Get completed bookings
    public List<Bookings> getCompletedBookings() {
        return bookingRepository.findByBookingStatus("Completed");
    }

    // Confirm a booking (Change status from "Pending" to "Confirmed")
    public String confirmBooking(Long bookingId) {
        Bookings booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found!"));

        if (!"Pending".equalsIgnoreCase(booking.getBookingStatus())) {
            return "Booking is not in pending status!";
        }

        booking.setBookingStatus("Confirmed");
        bookingRepository.save(booking);
        return "Booking confirmed successfully!";
    }
}