package com.example.web_login.repo;

import com.example.web_login.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    // Custom query to find invoices by customer name
    List<Invoice> findByCustomerNameContainingIgnoreCase(String customerName);
}
