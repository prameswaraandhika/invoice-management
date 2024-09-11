package com.prameswaradev.invoice_management.service;

import com.prameswaradev.invoice_management.dao.VirtualAccountDao;
import com.prameswaradev.invoice_management.entity.PaymentProvider;
import com.prameswaradev.invoice_management.entity.VirtualAccount;
import com.prameswaradev.invoice_management.exception.VirtualAccountAlreadyPaidException;
import com.prameswaradev.invoice_management.exception.VirtualAccountNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PaymentService {

    private final VirtualAccountDao virtualAccountDao;

    public void pay(PaymentProvider paymentProvider,
                    String companyId,
                    String accountNumber,
                    BigDecimal amount,
                    String reference) throws VirtualAccountNotFoundException, VirtualAccountAlreadyPaidException {

//        cek apakah va ada?
        var virtualAccount = virtualAccountDao.findByPaymentProviderAndCompanyIdAndAccountNumber(
                paymentProvider, companyId, accountNumber
        ).orElseThrow(()-> new VirtualAccountNotFoundException("VA "+ companyId + ", accountNumber " + accountNumber +
                ", " +paymentProvider.getCode()+". not found"));

//        apakah sudah lunas?
        if (virtualAccount.getInvoice().getPaid()){
            throw new VirtualAccountAlreadyPaidException("VA "+ companyId + ", accountNumber " + accountNumber +
                    ", " +paymentProvider.getCode()+". already paid");
        }
//        apakah total akumulasi pembayaran < nilai tagihan
//        update status va menjadi lunas, jika total akumulasi tercapai
//        update status invoice menjadi lunas
//        insert ke table payment
//        notifikasi

    }
}
