package com.ccamilofierro.billing.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.ccamilofierro.billing.model.Invoice;

public interface InvoiceService {
    List<Invoice> getAllInvoices();
    Invoice getInvoiceById(Long id);
    Invoice createInvoice(Invoice invoice);
    Invoice updateInvoice(Long id, Invoice invoice);
    void deleteInvoice(Long id);
    List<Invoice> getInvoicesByNit(Long nit);
    List<Invoice> getInvoicesAboveAmount(BigDecimal amount);
    List<Invoice> getInvoicesInDateRange(LocalDateTime startDate, LocalDateTime endDate);
}
