package com.ccamilofierro.billing.service;

import java.util.List;

import com.ccamilofierro.billing.model.Invoice;

public interface InvoiceService {
    List<Invoice> getAllInvoices();
    Invoice getInvoiceById(Long id);
    Invoice createInvoice(Invoice invoice);
    Invoice updateInvoice(Invoice invoice);
    void deleteInvoice(Long id);
}
