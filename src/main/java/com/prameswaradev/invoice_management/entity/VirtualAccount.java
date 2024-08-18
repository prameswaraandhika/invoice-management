package com.prameswaradev.invoice_management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Data
@SQLDelete(sql = "UPDATE virtual_account SET status_record = 'INACTIVE' WHERE id=?")
@Where(clause = "status_record = 'ACTIVE'")
public class VirtualAccount extends BaseEntity{
    @NotNull
    @ManyToOne @JoinColumn(name = "id_payment_provider")
    private PaymentProvider paymentProvider;

    @NotNull
    @ManyToOne @JoinColumn(name = "id_invoice")
    private Invoice invoice;

    @NotNull @NotEmpty
    private String companyId;
    @NotNull @NotEmpty
    private String number;

}
