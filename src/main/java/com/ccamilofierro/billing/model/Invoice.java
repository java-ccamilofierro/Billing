package com.ccamilofierro.billing.model;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Invoice extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private BigDecimal totalAmount;

    @Embedded
    private InvoiceStatus status;
}

@Embeddable
@Data
class InvoiceStatus {
    private String status;
}