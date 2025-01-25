package com.kushi.in.kushi.controller;

import com.kushi.in.kushi.entity.Services;  // Use 'Services' here as well
import com.kushi.in.kushi.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    // Create or update a service
    @PostMapping
    public ResponseEntity<Services> createService(@RequestBody Services service) {
        Services savedService = serviceService.saveService(service);
        return new ResponseEntity<>(savedService, HttpStatus.CREATED);
    }

    // Get all services
    @GetMapping
    public ResponseEntity<List<Services>> getAllServices() {
        List<Services> services = serviceService.getAllServices();
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

    // Get a service by ID
    @GetMapping("/{serviceId}")
    public ResponseEntity<Services> getServiceById(@PathVariable int serviceId) {
        Optional<Services> service = serviceService.getServiceById(serviceId);
        return service.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Get a service by name
    @GetMapping("/name/{serviceName}")
    public ResponseEntity<Services> getServiceByName(@PathVariable String serviceName) {
        Optional<Services> service = serviceService.getServiceByName(serviceName);
        return service.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Get services by active status
    @GetMapping("/active/{active}")
    public ResponseEntity<List<Services>> getServicesByActiveStatus(@PathVariable String active) {
        List<Services> services = serviceService.getServicesByActiveStatus(active);
        return services.isEmpty() ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(services, HttpStatus.OK);
    }

    // Get services by discount percentage
    @GetMapping("/discount/{discountPercentage}")
    public ResponseEntity<List<Services>> getServicesByDiscountPercentage(@PathVariable BigDecimal discountPercentage) {
        List<Services> services = serviceService.getServicesByDiscountPercentage(discountPercentage);
        return services.isEmpty() ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(services, HttpStatus.OK);
    }

    // Get services by service type
    @GetMapping("/type/{serviceType}")
    public ResponseEntity<List<Services>> getServicesByType(@PathVariable String serviceType) {
        List<Services> services = serviceService.getServicesByType(serviceType);
        return services.isEmpty() ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(services, HttpStatus.OK);
    }

    // Get services created by a specific user
    @GetMapping("/created-by/{createdBy}")
    public ResponseEntity<List<Services>> getServicesByCreatedBy(@PathVariable String createdBy) {
        List<Services> services = serviceService.getServicesByCreatedBy(createdBy);
        return services.isEmpty() ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(services, HttpStatus.OK);
    }

    // Delete a service by ID
    @DeleteMapping("/{serviceId}")
    public ResponseEntity<Void> deleteServiceById(@PathVariable int serviceId) {
        serviceService.deleteServiceById(serviceId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
