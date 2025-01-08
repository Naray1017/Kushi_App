package com.example.web_login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.web_login.entity.Serevice_add;
import com.example.web_login.repo.Admin_repo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class ServiceController {

    @Autowired
    private Admin_repo serviceRepository;

    private static final String UPLOAD_DIR = "uploads/";

    @GetMapping("/add-service")
    public String showAddServiceForm1(Model model) {
        model.addAttribute("service", new Serevice_add());
        return "Addmin_Add_service"; // Ensure the view name matches the template
    }

    @PostMapping("/add-service")
    public String addService(@ModelAttribute Serevice_add service, Model model) {
        String imagePath = null;

        try {
            if (service.getImageFile() != null && !service.getImageFile().isEmpty()) {
                // Validate file type
                String contentType = service.getImageFile().getContentType();
                if (contentType == null || !contentType.startsWith("image")) {
                    model.addAttribute("error", "Invalid file type. Only image files are allowed.");
                    return "Addmin_Add_service"; // Return to the form with error message
                }

                // Ensure the upload directory exists
                Path uploadPath = Paths.get(UPLOAD_DIR);
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }

                // Generate a unique file name
                String fileName = System.currentTimeMillis() + "_" + service.getImageFile().getOriginalFilename();
                Path filePath = uploadPath.resolve(fileName);

                // Transfer the file to the directory
                service.getImageFile().transferTo(filePath.toFile());
                imagePath = filePath.toString(); // Save the file path
            } else if (service.getImage() != null && !service.getImage().isEmpty()) {
                imagePath = service.getImage(); // Use provided image URL if available
            }

            service.setImage(imagePath); // Set image path in the entity
            serviceRepository.save(service); // Save the entity

        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("error", "File upload failed. Please try again.");
            return "Addmin_Add_service"; // Return to the form with error message
        }

        return "redirect:/add-service?success"; // Redirect with success message
    }
}
