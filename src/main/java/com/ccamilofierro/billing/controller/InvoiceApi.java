package com.ccamilofierro.billing.controller;

import com.ccamilofierro.billing.model.Invoice;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Tag(name = "Invoice", description = "API de gestión de facturas")
public interface InvoiceApi {

    @Operation(summary = "Obtener todas las facturas", description = "Retorna una lista de todas las facturas en el sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Operación exitosa",
                     content = @Content(schema = @Schema(implementation = Invoice.class)))
    })
    @GetMapping
    List<Invoice> getAllInvoices();

    @Operation(summary = "Obtener una factura por ID", description = "Retorna una factura única basada en su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Factura encontrada",
                     content = @Content(schema = @Schema(implementation = Invoice.class))),
        @ApiResponse(responseCode = "404", description = "Factura no encontrada")
    })
    @GetMapping("/{id}")
    ResponseEntity<Invoice> getInvoiceById(@Parameter(description = "ID de la factura", required = true) @PathVariable(value = "id") Long invoiceId);

    @Operation(summary = "Crear una nueva factura", description = "Crea una nueva factura con la información proporcionada")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Factura creada exitosamente",
                     content = @Content(schema = @Schema(implementation = Invoice.class))),
        @ApiResponse(responseCode = "400", description = "Datos de factura inválidos")
    })
    @PostMapping
    Invoice createInvoice(@Parameter(description = "Detalles de la factura a crear", required = true) @RequestBody Invoice invoice);

    @Operation(summary = "Actualizar una factura existente", description = "Actualiza una factura existente con la información proporcionada")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Factura actualizada exitosamente",
                     content = @Content(schema = @Schema(implementation = Invoice.class))),
        @ApiResponse(responseCode = "400", description = "Datos de factura inválidos"),
        @ApiResponse(responseCode = "404", description = "Factura no encontrada")
    })
    @PutMapping("/{id}")
    ResponseEntity<Invoice> updateInvoice(@Parameter(description = "ID de la factura a actualizar", required = true) @PathVariable(value = "id") Long invoiceId,
                                          @Parameter(description = "Detalles actualizados de la factura", required = true) @RequestBody Invoice invoiceDetails);

    @Operation(summary = "Eliminar una factura", description = "Elimina una factura existente basada en su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Factura eliminada exitosamente"),
        @ApiResponse(responseCode = "404", description = "Factura no encontrada")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteInvoice(@Parameter(description = "ID de la factura a eliminar", required = true) @PathVariable(value = "id") Long invoiceId);

    @Operation(summary = "Obtener facturas por NIT del cliente", description = "Retorna una lista de facturas asociadas a un NIT específico")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Operación exitosa",
                     content = @Content(schema = @Schema(implementation = Invoice.class)))
    })
    @GetMapping("/customer/{nit}")
    List<Invoice> getInvoicesByNit(@Parameter(description = "NIT del cliente", required = true) @PathVariable(value = "nit") Long nit);

    @Operation(summary = "Obtener facturas por encima de un monto", description = "Retorna una lista de facturas cuyo monto total supera el valor especificado")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Operación exitosa",
                     content = @Content(schema = @Schema(implementation = Invoice.class)))
    })
    @GetMapping("/amount/{amount}")
    List<Invoice> getInvoicesAboveAmount(@Parameter(description = "Monto mínimo de factura", required = true) @PathVariable(value = "amount") BigDecimal amount);

    @Operation(summary = "Obtener facturas en un rango de fechas", description = "Retorna una lista de facturas creadas dentro del rango de fechas especificado")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Operación exitosa",
                     content = @Content(schema = @Schema(implementation = Invoice.class)))
    })
    @GetMapping("/date-range")
    List<Invoice> getInvoicesInDateRange(
        @Parameter(description = "Fecha de inicio (formato: yyyy-MM-dd HH:mm:ss)", required = true)
        @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime startDate,
        @Parameter(description = "Fecha de fin (formato: yyyy-MM-dd HH:mm:ss)", required = true)
        @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime endDate);
}