package com.ccamilofierro.billing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccamilofierro.billing.model.Invoice;
import com.ccamilofierro.billing.service.InvoiceService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @GetMapping
    public List<Invoice> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable(value = "id") Long invoiceId) {
        Invoice invoice = invoiceService.getInvoiceById(invoiceId);
        return ResponseEntity.ok().body(invoice);
    }

    @PostMapping
    public Invoice createInvoice(@RequestBody Invoice invoice) {
        return invoiceService.createInvoice(invoice);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Invoice> updateInvoice(@PathVariable(value = "id") Long invoiceId,
     @RequestBody Invoice invoiceDetails) {
        Invoice updatedInvoice = invoiceService.updateInvoice(invoiceId, invoiceDetails);
        return ResponseEntity.ok(updatedInvoice);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteInvoice(@PathVariable(value = "id") Long invoiceId) {
        invoiceService.deleteInvoice(invoiceId);
        return ResponseEntity.ok().build();
    }

}
