package com.example.web_login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.web_login.entity.User;
import com.example.web_login.repo.Userrepo;

import jakarta.validation.Valid;

@Controller

public class UserController {

    @Autowired
    private Userrepo userRepo;

    @GetMapping("/")
    public String home() {
        return "home";  
    }

    @GetMapping("/home2")
    public String about() {
        return "home2";  
    }
    @GetMapping("/Service_Booking")
    public String ServiceBooking(Model model) {
        model.addAttribute("user", new User());  // Add the user object to the model
        return "ServiceBooking";  // Return the view name
    }

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@ModelAttribute @Valid User user, BindingResult bindingResult) {
        // Validate required fields
        if (bindingResult.hasErrors()) {
            String errorMessage = bindingResult.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }

        try {
            // Save user if all fields are valid
            userRepo.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("User added successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error while adding user: " + e.getMessage());
        }
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            List<User> users = userRepo.findAll();
            if (users.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
            return ResponseEntity.status(HttpStatus.OK).body(users);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }



    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User user) {
        try {
            // Find the existing user
            User existingUser = userRepo.findById(id).orElse(null);
            if (existingUser == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
            }

            // Update the fields of the existing user
            if (user.getUsername() != null) {
                existingUser.setUsername(user.getUsername());
            }
            if (user.getServicename() != null) {
                existingUser.setServicename(user.getServicename());
            }
            if (user.getEmail() != null) {
                existingUser.setEmail(user.getEmail());
            }
            if (user.getPhonenumber() != null) {
                existingUser.setPhonenumber(user.getPhonenumber());
            }
            if (user.getBookingDate() != null) {
                existingUser.setBookingDate(user.getBookingDate());
            }
           

            // Save the updated user
            userRepo.save(existingUser);
            return ResponseEntity.status(HttpStatus.OK).body("User updated successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error while updating user: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        try {
            if (!userRepo.existsById(id)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
            }
            userRepo.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error while deleting user: " + e.getMessage());
        }
    }
}
