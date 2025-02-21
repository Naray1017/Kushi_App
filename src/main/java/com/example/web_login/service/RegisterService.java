package com.example.web_login.service;

import com.example.web_login.entity.Register;
import com.example.web_login.repo.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterService {

    @Autowired
    private RegisterRepository registerRepository;

    public boolean registerUser(Register register) {
        Optional<Register> existingUser = registerRepository.findByEmail(register.getEmail());

        if (existingUser.isPresent()) {
            return false; // Email already exists
        }

        registerRepository.save(register);
        return true;
    }
}
