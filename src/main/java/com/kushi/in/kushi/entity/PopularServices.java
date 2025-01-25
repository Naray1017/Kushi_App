package com.kushi.in.kushi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_most_booked_services")  // Make sure this is the correct table name
public class PopularServices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;  // Assuming this is the service/customer identifier; change if needed
    private String serviceName;  // Service Name
    private Double rating;  // Rating of the service (null for now)
    private Double amount;  // Amount for the service
    private Long bookingCount;  // Total number of bookings for this service

    // Getters and Setters
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getBookingCount() {
        return bookingCount;
    }

    public void setBookingCount(Long bookingCount) {
        this.bookingCount = bookingCount;
    }
}
