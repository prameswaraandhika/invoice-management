package com.prameswaradev.invoice_management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class Invoice extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "id_invoice_type")
    @NotNull
    private InvoiceType invoiceType;
    private String number;
    private LocalDate dueDate;
    private String description;
    private BigDecimal amount;
    private Boolean paid;

}
