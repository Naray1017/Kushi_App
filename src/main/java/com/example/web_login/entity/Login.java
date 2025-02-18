package com.example.web_login.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "login")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // User ID

    @Column(nullable = false, unique = true)
    private String adminId; // Unique Admin ID

    @Column(nullable = false)
    private String adminName; // Admin Name

    @Column(nullable = false, unique = true)
    private String adminUsername; // Admin Username

    @Column(nullable = false, unique = true)
    private String email; // Admin Email

    @Column(nullable = false)
    private String password; // Admin Password

    @Column(nullable = false)
    private String phoneNumber; // Admin Phone Number

    @Column(nullable = true)
    private String profilePicture; // Profile Picture (URL or Path)

    public String getEmail() {
        return this.email;
    }

    public Object getPassword() {
        return this.password;
    }
}
