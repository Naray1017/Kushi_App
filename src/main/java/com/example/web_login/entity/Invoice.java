package com.example.web_login.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "invoice") // Table name explicitly set
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String invoiceNumber;

    @Column(nullable = false)
    private String customerName;

    @Temporal(TemporalType.DATE)
    private Date date;

    private Double totalAmount = 0.0;
    private Double discount = 0.0;
    private Double tax = 0.0;

    private String serviceName;
    private String serviceType;
    private Long bookingId;

    public Invoice() {
    }

    // Calculate total amount with discount and tax
    public void calculateTotalAmount() {
        double discountAmount = (discount / 100) * totalAmount;
        double subtotal = totalAmount - discountAmount;
        double taxAmount = (tax / 100) * subtotal;
        this.totalAmount = subtotal + taxAmount;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getInvoiceNumber() { return invoiceNumber; }
    public void setInvoiceNumber(String invoiceNumber) { this.invoiceNumber = invoiceNumber; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public Double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(Double totalAmount) { this.totalAmount = totalAmount; }

    public Double getDiscount() { return discount; }
    public void setDiscount(Double discount) { this.discount = discount; }

    public Double getTax() { return tax; }
    public void setTax(Double tax) { this.tax = tax; }

    public String getServiceName() { return serviceName; }
    public void setServiceName(String serviceName) { this.serviceName = serviceName; }

    public String getServiceType() { return serviceType; }
    public void setServiceType(String serviceType) { this.serviceType = serviceType; }

    public Long getBookingId() { return bookingId; }
    public void setBookingId(Long bookingId) { this.bookingId = bookingId; }
}
