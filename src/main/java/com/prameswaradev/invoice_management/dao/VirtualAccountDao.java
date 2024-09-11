package com.prameswaradev.invoice_management.dao;

import com.prameswaradev.invoice_management.entity.PaymentProvider;
import com.prameswaradev.invoice_management.entity.VirtualAccount;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;


public interface VirtualAccountDao extends PagingAndSortingRepository<VirtualAccount, String> {
    Optional<VirtualAccount> findByPaymentProviderAndCompanyIdAndAccountNumber(PaymentProvider paymentProvider,
                                                                               String companyId,
                                                                               String accountNumber);
}
