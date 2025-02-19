package com.example.web_login.controller;

import com.example.web_login.entity.Login;
import com.example.web_login.service.LoginService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/log")
public class LoginController {

    @Autowired
    private LoginService loginService;

    // Login endpoint
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Login login, HttpSession session) {
        Map<String, String> response = new HashMap<>();
        boolean isValidUser = loginService.validateLoginByEmail(login);

        if (isValidUser) {
            session.setAttribute("adminEmail", login.getEmail()); // Store email in session
            response.put("message", "Login Successful");
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Invalid credentials");
            return ResponseEntity.status(401).body(response); // 401 Unauthorized
        }
    }

    // Logout endpoint
    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        session.invalidate(); // Invalidate the session
        return ResponseEntity.ok("Logout Successful");
    }

    // Get session user details
    @GetMapping("/users")
    public ResponseEntity<List<Login>> getAllUsers() {
        List<Login> users = loginService.findAllUsers(); // Fetch all users from DB
        return ResponseEntity.ok(users);
    }


    // Fetch logged-in admin profile
    @GetMapping("/profile")
    public ResponseEntity<Map<String, String>> getProfile(HttpSession session) {
        Map<String, String> response = new HashMap<>();
        String adminEmail = (String) session.getAttribute("adminEmail");

        if (adminEmail == null) {
            response.put("message", "User not logged in");
            return ResponseEntity.status(401).body(response);
        }

        Login login = loginService.findByEmail(adminEmail);

        if (login == null) {
            response.put("message", "Admin not found");
            return ResponseEntity.status(404).body(response);
        }

        response.put("adminName", login.getAdminUsername());
        response.put("adminId", String.valueOf(login.getId()));
        response.put("profilePicture", login.getProfilePicture());

        return ResponseEntity.ok(response);
    }
}
