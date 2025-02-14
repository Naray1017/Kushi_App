package com.example.web_login.service;

import com.example.web_login.entity.Invoice;
import com.example.web_login.repo.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class InvoiceService {

    private static final Logger logger = Logger.getLogger(InvoiceService.class.getName());

    @Autowired
    private InvoiceRepository invoiceRepository;

    // Get all invoices
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    // Get invoice by ID
    public Invoice getInvoiceById(Long id) {
        Optional<Invoice> invoice = invoiceRepository.findById(id);
        if (invoice.isPresent()) {
            return invoice.get();
        } else {
            logger.warning("Invoice with ID " + id + " not found!");
            throw new RuntimeException("Invoice not found with ID: " + id);
        }
    }

    // Create a new invoice
    public Invoice createInvoice(Invoice invoice) {
        if (invoice.getTotalAmount() == null || invoice.getTotalAmount() <= 0) {
            throw new IllegalArgumentException("Total amount must be greater than zero.");
        }
        invoice.calculateTotalAmount();
        return invoiceRepository.save(invoice);
    }

    // Delete invoice by ID
    public void deleteInvoice(Long id) {
        if (!invoiceRepository.existsById(id)) {
            throw new RuntimeException("Invoice not found with ID: " + id);
        }
        invoiceRepository.deleteById(id);
    }
}
