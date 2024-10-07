package com.ccamilofierro.billing.model;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
@Schema(name = "InvoiceItem", description = "Ítem individual de una factura")
public class InvoiceItem {
    @Schema(description = "Descripción del ítem", example = "Product A")
    private String description;
    @Schema(description = "Cantidad del ítem", example = "2")
    private int quantity;
    @Schema(description = "Precio unitario del ítem", example = "500.00")
    private BigDecimal unitPrice;
}