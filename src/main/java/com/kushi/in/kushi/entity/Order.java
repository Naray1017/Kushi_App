package com.kushi.in.kushi.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate;

    @Column(name = "product_details", columnDefinition = "TEXT")
    private String productDetails; // Assuming it contains descriptive details about the products

    @Column(name = "product_name", nullable = true)
    private String productName; // Optional, can be NULL if not used in all cases

    @Column(name = "total_amount", nullable = false)
    private Double totalAmount; // Assuming it's the total payable amount for the order

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "total_price", nullable = false)
    private Double totalPrice;

    // Default constructor
    public Order() {
    }

    // Parameterized constructor
    public Order(Long id, String customerName, LocalDateTime orderDate, String productDetails, String productName,
                 Double totalAmount, String status, Double totalPrice) {
        this.id = id;
        this.customerName = customerName;
        this.orderDate = orderDate;
        this.productDetails = productDetails;
        this.productName = productName;
        this.totalAmount = totalAmount;
        this.status = status;
        this.totalPrice = totalPrice;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(String productDetails) {
        this.productDetails = productDetails;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}