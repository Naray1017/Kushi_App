package com.example.web_login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.web_login.entity.Serevice_add;
import com.example.web_login.repo.Admin_repo;

@Controller
public class ServiceController {

	 @Autowired
	    private Admin_repo admin_repo;
    // This will handle GET requests for "/service"
   

    
	 @GetMapping("/service")
	 public ResponseEntity<List<Serevice_add>> getAllServices() {
	     try {
	         // Fetch the list of users or services from the repository
	         List<Serevice_add> serviceList = admin_repo.findAll();
	         
	         // Check if the list is empty
	         if (serviceList.isEmpty()) {
	             return ResponseEntity.status(HttpStatus.NO_CONTENT).build();  // No data found, return 204 No Content
	         }
	         
	         // If data exists, return the list with 200 OK status
	         return ResponseEntity.status(HttpStatus.OK).body(serviceList);
	         
	     } catch (Exception e) {
	         // If any error occurs, return 500 Internal Server Error
	         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	     }
	 }
 
	 
    // This will handle requests for "/service/another"
    @RequestMapping("/service/another")
    public String anotherService() {
        return "anotherService";  // returns a view named 'anotherService.jsp' or 'anotherService.html'
    }

    // You can also use more specific mappings (POST, PUT, etc.)
    // @PostMapping, @PutMapping, etc.
}
