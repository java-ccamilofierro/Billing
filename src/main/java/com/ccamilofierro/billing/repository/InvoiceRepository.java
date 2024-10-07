package com.ccamilofierro.billing.repository;

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
}
