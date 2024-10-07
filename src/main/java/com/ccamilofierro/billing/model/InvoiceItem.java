package com.ccamilofierro.billing.model;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
@Schema(name = "InvoiceItem", description = "Individual item of an invoice")
public class InvoiceItem {
    @Schema(description = "Item description", example = "Product A")
    private String description;
    
    @Schema(description = "Item quantity", example = "2")
    private int quantity;
    
    @Schema(description = "Unit price of the item", example = "500.00")
    private BigDecimal unitPrice;
}
