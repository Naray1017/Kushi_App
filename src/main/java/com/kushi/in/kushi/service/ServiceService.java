package com.kushi.in.kushi.service;

import com.kushi.in.kushi.entity.Services;  // Use 'Services' as the entity
import com.kushi.in.kushi.repo.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    // Save or update a service
    public Services saveService(Services service) {
        return serviceRepository.save(service);
    }

    // Get all services
    public List<Services> getAllServices() {
        return serviceRepository.findAll();
    }

    // Get a service by ID
    public Optional<Services> getServiceById(int serviceId) {
        return serviceRepository.findById(serviceId);
    }

    // Get a service by name
    public Optional<Services> getServiceByName(String serviceName) {
        return serviceRepository.findByServiceName(serviceName);
    }

    // Get all services that are active or inactive
    public List<Services> getServicesByActiveStatus(String active) {
        return serviceRepository.findByActive(active);
    }

    // Get all services with a discount percentage greater than a specified value
    public List<Services> getServicesByDiscountPercentage(BigDecimal discountPercentage) {
        return serviceRepository.findByDiscountPercentageGreaterThan(discountPercentage);
    }

    // Get services by service type
    public List<Services> getServicesByType(String serviceType) {
        return serviceRepository.findByServiceType(serviceType);
    }

    // Get all services created by a specific user
    public List<Services> getServicesByCreatedBy(String createdBy) {
        return serviceRepository.findByCreatedBy(createdBy);
    }

    // Delete a service by ID
    public void deleteServiceById(int serviceId) {
        serviceRepository.deleteById(serviceId);
    }
}
