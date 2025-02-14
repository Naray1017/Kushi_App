package com.example.web_login.controller;

import com.example.web_login.entity.Invoice;
import com.example.web_login.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

    private static final Logger logger = Logger.getLogger(InvoiceController.class.getName());

    @Autowired
    private InvoiceService invoiceService;

    // Get all invoices
    @GetMapping
    public ResponseEntity<List<Invoice>> getAllInvoices() {
        logger.info("Fetching all invoices...");
        List<Invoice> invoices = invoiceService.getAllInvoices();
        return ResponseEntity.ok(invoices);
    }

    // Get an invoice by its ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getInvoiceById(@PathVariable Long id) {
        try {
            Invoice invoice = invoiceService.getInvoiceById(id);
            return ResponseEntity.ok(invoice);
        } catch (RuntimeException e) {
            logger.warning("Invoice not found with ID: " + id);
            return ResponseEntity.status(404).body("Invoice not found with ID: " + id);
        }
    }

    // Create a new invoice
    @PostMapping
    public ResponseEntity<?> createInvoice(@RequestBody Invoice invoice) {
        try {
            Invoice savedInvoice = invoiceService.createInvoice(invoice);
            return ResponseEntity.status(201).body(savedInvoice);
        } catch (IllegalArgumentException e) {
            logger.warning("Invalid invoice data: " + e.getMessage());
            return ResponseEntity.badRequest().body("Invalid invoice data: " + e.getMessage());
        }
    }

    // Delete an invoice by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteInvoice(@PathVariable Long id) {
        try {
            invoiceService.deleteInvoice(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            logger.warning("Invoice not found with ID: " + id);
            return ResponseEntity.status(404).body("Invoice not found with ID: " + id);
        }
    }
}
