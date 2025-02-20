package com.example.web_login.controller;

import com.example.web_login.entity.Login;
import com.example.web_login.service.LoginService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/log")
public class LoginController {

    @Autowired
    private LoginService loginService;

    // Login endpoint (using email)
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Login login, HttpSession session) {
        Map<String, String> response = new HashMap<>();
        boolean isValidUser = loginService.validateLoginByEmail(login);

        if (isValidUser) {
            session.setAttribute("Email", login.getEmail()); // Store email in session
            response.put("message", "Login Successful");
            return ResponseEntity.ok(response); // Return success with 200 OK
        } else {
            response.put("message", "Your credentials are wrong"); // Custom error message
            return ResponseEntity.status(200).body(response); // Return 200 OK but with the error message
        }
    }

    // Logout endpointd
    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        session.invalidate(); // Invalidate the session
        return ResponseEntity.ok("Logout Successful");
    }

}
