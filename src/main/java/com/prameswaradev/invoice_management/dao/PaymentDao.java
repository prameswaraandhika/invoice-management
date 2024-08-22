package com.prameswaradev.invoice_management.dao;

import com.prameswaradev.invoice_management.entity.Payment;
import com.prameswaradev.invoice_management.entity.VirtualAccount;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PaymentDao  extends PagingAndSortingRepository<Payment, String> {
}
