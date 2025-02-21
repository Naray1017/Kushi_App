package com.example.web_login.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER_LOGIN_INFO")
public class Register {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "USER_FIRST_NAME", nullable = false, length = 50)
    private String firstName;

    @Column(name = "USER_LAST_NAME", nullable = false, length = 50)
    private String lastName;

    @Column(name = "PHONE_NUMBER", length = 15)
    private String phoneNumber;

    @Column(name = "EMAIL", nullable = false, length = 100, unique = true)
    private String email;

    @Column(name = "PASSWORD", nullable = false, length = 255)
    private String password; // Added password field for authentication

    @Column(name = "GENDER", nullable = false, columnDefinition = "CHAR(1) DEFAULT 'M'")
    private char gender;

    @Column(name = "LAST_LOGIN")
    private Timestamp lastLogin;

    @Column(name = "PROFILE_PICTURE", columnDefinition = "VARCHAR(255) DEFAULT 'default_profile.jpg'")
    private String profilePicture;

    public String getEmail() {
        return email;
    }

}
