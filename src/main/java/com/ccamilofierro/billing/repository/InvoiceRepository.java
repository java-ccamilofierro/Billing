package com.ccamilofierro.billing.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.ccamilofierro.billing.model.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long>{
    @Query("SELECT i FROM Invoice i WHERE i.nit = :nit")
    List<Invoice> findByInvoicesNit(@Param("nit") Long nit);

    @Query("SELECT i FROM Invoice i WHERE i.totalAmount > :amount")
    List<Invoice> findInvoicesAboveAmount(@Param("amount") BigDecimal amount);

    @Query("SELECT i FROM Invoice i WHERE i.createdAt BETWEEN :startDate AND :endDate")
    List<Invoice> findInvoicesInDateRange(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
}
