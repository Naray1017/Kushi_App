package com.kushi.in.kushi.repo;

import com.kushi.in.kushi.entity.Services;  // Use the correct entity name 'Services'
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ServiceRepository extends JpaRepository<Services, Integer> {  // Use 'Services' instead of 'Service'

    // Find a service by its name
    Optional<Services> findByServiceName(String serviceName);

    // Find services by their active status
    List<Services> findByActive(String active);

    // Find services with a discount percentage greater than the specified value
    List<Services> findByDiscountPercentageGreaterThan(BigDecimal discountPercentage);

    // Find services by their type
    List<Services> findByServiceType(String serviceType);

    // Find services created by a specific user
    List<Services> findByCreatedBy(String createdBy);
}
