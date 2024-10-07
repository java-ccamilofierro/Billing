package com.ccamilofierro.billing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ccamilofierro.billing.model.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long>{

}
