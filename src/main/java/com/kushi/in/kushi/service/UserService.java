package com.kushi.in.kushi.service;


import com.kushi.in.kushi.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.kushi.in.kushi.entity.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Fetch all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get user by id
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // Save a new user or update an existing user
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Delete user by id
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Update user details (PUT operation)
    public User updateUser(Long id, User userDetails) {
        Optional<User> existingUserOpt = userRepository.findById(id);
        if (existingUserOpt.isPresent()) {
            User existingUser = existingUserOpt.get();
            existingUser.setUsername(userDetails.getUsername()); // Update username
            existingUser.setPassword(userDetails.getPassword()); // Update password
            existingUser.setRole(userDetails.getRole()); // Update role
            return userRepository.save(existingUser); // Save the updated user
        }
        return null;
    }

    // Method for adding a new user (POST operation)
    public User addUser(User user) {
        return userRepository.save(user);
    }

    // Method for deleting a user (DELETE operation)
    public void removeUser(Long id) {
        userRepository.deleteById(id);
    }
}