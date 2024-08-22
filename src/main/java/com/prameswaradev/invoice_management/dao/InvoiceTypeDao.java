package com.prameswaradev.invoice_management.dao;

import com.prameswaradev.invoice_management.entity.Invoice;
import com.prameswaradev.invoice_management.entity.InvoiceType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceTypeDao extends CrudRepository<InvoiceType, String> {
    InvoiceType findByCode(String code);
}
