package com.example.web_login.service;

import com.example.web_login.entity.Login;
import com.example.web_login.repo.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    // Validate login credentials using email
    public boolean validateLoginByEmail(Login login) {
        // Find user by email
        Login storedLogin = loginRepository.findByEmail(login.getEmail());

        // If user is found and the passwords match
        if (storedLogin != null && storedLogin.getPassword().equals(login.getPassword())) {
            return true; // Valid credentials
        }
        return false; // Invalid credentials
    }
}
