package com.ccamilofierro.billing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccamilofierro.billing.exception.ResourceNotFoundException;
import com.ccamilofierro.billing.model.Invoice;
import com.ccamilofierro.billing.repository.InvoiceRepository;

import jakarta.transaction.Transactional;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice getInvoiceById(Long id) {
        return invoiceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Invoice not found with id: " + id));
    }

    @Override
    @Transactional
    public Invoice createInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);   
    }

    @Override
    @Transactional
    public Invoice updateInvoice(Long id,Invoice invoice) {
        Invoice invoiceToUpdate = getInvoiceById(id);
        invoiceToUpdate.setCustomerName(invoice.getCustomerName());
        invoiceToUpdate.setInvoiceDate(invoice.getInvoiceDate());
        invoiceToUpdate.setTotalAmount(invoice.getTotalAmount());
        invoiceToUpdate.setStatus(invoice.getStatus());
        return invoiceToUpdate;
    }

    @Override
    @Transactional
    public void deleteInvoice(Long id) {
        Invoice invoiceToDelete = getInvoiceById(id);
        invoiceRepository.delete(invoiceToDelete);
    }
}
