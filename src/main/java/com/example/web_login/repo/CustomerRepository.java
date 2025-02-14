package com.example.web_login.repo;

import com.example.web_login.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c FROM Customer c ORDER BY c.firstName ASC") // Example logic, adjust as needed
    List<Customer> findTopCustomers();
}
