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

@Tag(name = "Invoice", description = "Invoice management API")
public interface InvoiceApi {

    @Operation(summary = "Get all invoices", description = "Returns a list of all invoices in the system")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successful operation",
                     content = @Content(schema = @Schema(implementation = Invoice.class)))
    })
    @GetMapping
    List<Invoice> getAllInvoices();

    @Operation(summary = "Get an invoice by ID", description = "Returns a single invoice based on its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Invoice found",
                     content = @Content(schema = @Schema(implementation = Invoice.class))),
        @ApiResponse(responseCode = "404", description = "Invoice not found")
    })
    @GetMapping("/{id}")
    ResponseEntity<Invoice> getInvoiceById(@Parameter(description = "Invoice ID", required = true) @PathVariable(value = "id") Long invoiceId);

    @Operation(summary = "Create a new invoice", description = "Creates a new invoice with the provided information")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Invoice created successfully",
                     content = @Content(schema = @Schema(implementation = Invoice.class))),
        @ApiResponse(responseCode = "400", description = "Invalid invoice data")
    })
    @PostMapping
    Invoice createInvoice(@Parameter(description = "Invoice details to create", required = true) @RequestBody Invoice invoice);

    @Operation(summary = "Update an existing invoice", description = "Updates an existing invoice with the provided information")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Invoice updated successfully",
                     content = @Content(schema = @Schema(implementation = Invoice.class))),
        @ApiResponse(responseCode = "400", description = "Invalid invoice data"),
        @ApiResponse(responseCode = "404", description = "Invoice not found")
    })
    @PutMapping("/{id}")
    ResponseEntity<Invoice> updateInvoice(@Parameter(description = "ID of the invoice to update", required = true) @PathVariable(value = "id") Long invoiceId,
                                          @Parameter(description = "Updated invoice details", required = true) @RequestBody Invoice invoiceDetails);

    @Operation(summary = "Delete an invoice", description = "Deletes an existing invoice based on its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Invoice deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Invoice not found")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteInvoice(@Parameter(description = "ID of the invoice to delete", required = true) @PathVariable(value = "id") Long invoiceId);

    @Operation(summary = "Get invoices by customer NIT", description = "Returns a list of invoices associated with a specific NIT")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successful operation",
                     content = @Content(schema = @Schema(implementation = Invoice.class)))
    })
    @GetMapping("/customer/{nit}")
    List<Invoice> getInvoicesByNit(@Parameter(description = "Customer NIT", required = true) @PathVariable(value = "nit") Long nit);

    @Operation(summary = "Get invoices above a certain amount", description = "Returns a list of invoices where the total amount exceeds the specified value")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successful operation",
                     content = @Content(schema = @Schema(implementation = Invoice.class)))
    })
    @GetMapping("/amount/{amount}")
    List<Invoice> getInvoicesAboveAmount(@Parameter(description = "Minimum invoice amount", required = true) @PathVariable(value = "amount") BigDecimal amount);

    @Operation(summary = "Get invoices in a date range", description = "Returns a list of invoices created within the specified date range")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successful operation",
                     content = @Content(schema = @Schema(implementation = Invoice.class)))
    })
    @GetMapping("/date-range")
    List<Invoice> getInvoicesInDateRange(
        @Parameter(description = "Start date (format: yyyy-MM-dd HH:mm:ss)", required = true)
        @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime startDate,
        @Parameter(description = "End date (format: yyyy-MM-dd HH:mm:ss)", required = true)
        @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime endDate);
}
