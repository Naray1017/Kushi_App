package com.kushi.in.kushi.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kushi.in.kushi.entity.User;
import com.kushi.in.kushi.repo.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    // Fetch all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Fetch a user by ID
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // Save or update user
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Delete a user by ID
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Find user by ID with an exception if not found
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // Fetch users who are subscribed to a specific service
    public List<User> getUsersByService(String service) {
        return userRepository.findBySubscribedServicesContaining(service);
    }
}
