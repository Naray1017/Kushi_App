package com.example.web_login.controller;

import com.example.web_login.entity.Register;
import com.example.web_login.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/reg")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody Register register) {
        Map<String, String> response = new HashMap<>();

        boolean isRegistered = registerService.registerUser(register);

        if (isRegistered) {
            response.put("message", "Registration Successful");
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Email already exists");
            return ResponseEntity.status(400).body(response);
        }
    }
}
