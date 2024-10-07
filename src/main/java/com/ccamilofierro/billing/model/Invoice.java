package com.ccamilofierro.billing.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Invoice extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotNull(message = "El NIT no puede ser nulo")
    @Min(value = 1, message = "El NIT debe ser un número positivo")
    private Long nit;

    @Email(message = "El email debe ser válido")
    private String email;
    private String customerName;

    @NotNull(message = "El monto total no puede ser nulo")
    @DecimalMin(value = "0.0", inclusive = false, message = "El monto total debe ser mayor que cero")
    private BigDecimal totalAmount;

    @NotNull
    @Enumerated(EnumType.STRING)
    private InvoiceStatusEnum status;

    @ElementCollection
    @CollectionTable(name = "invoice_items", joinColumns = @JoinColumn(name = "invoice_id"))
    private List<InvoiceItem> items = new ArrayList<>();
}

