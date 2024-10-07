package com.ccamilofierro.billing.model;

import java.math.BigDecimal;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class InvoiceItem {
    private String description;
    private int quantity;
    private BigDecimal unitPrice;
}