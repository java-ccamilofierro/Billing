package com.ccamilofierro.billing.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private LocalDate invoiceDate;
    private BigDecimal totalAmount;

    @Embedded
    private InvoiceStatus status;
}

@Embeddable
@Data
class InvoiceStatus {
    private String status;
    private LocalDate lastUpdated;
}