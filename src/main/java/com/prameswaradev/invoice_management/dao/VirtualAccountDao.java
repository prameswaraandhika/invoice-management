package com.prameswaradev.invoice_management.dao;

import com.prameswaradev.invoice_management.entity.VirtualAccount;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface VirtualAccountDao extends PagingAndSortingRepository<VirtualAccount, String> {
}
