package com.kushi.in.kushi.entity;



import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderDescription;  // Example field, add other fields as needed

    // The user who placed the order
    @ManyToOne
    @JoinColumn(name = "user_id")  // This will create a foreign key in the Order table to link to the User
    private User user;  // The field representing the relation to User

    // Add orderDate field
    private LocalDate orderDate;  // The date when the order was placed

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
}
