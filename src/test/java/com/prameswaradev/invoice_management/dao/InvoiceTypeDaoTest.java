package com.prameswaradev.invoice_management.dao;

import com.prameswaradev.invoice_management.entity.InvoiceType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Sql(scripts = "/sql/delete_invoice_type.sql")
public class InvoiceTypeDaoTest {

    @Autowired
    private InvoiceTypeDao invoiceTypeDao;

    @Test
    public void testInsert(){
        var invoiceType = new InvoiceType();
        invoiceType.setName("VeronicaRaj");
        invoiceType.setCode("ipqqssc9yU2");
        invoiceTypeDao.save(invoiceType);

        System.out.println(invoiceType.getId());
        System.out.println(invoiceType.getName());
        System.out.println(invoiceType.getCode());
        System.out.println(invoiceType.getCreatedBy());
        System.out.println(invoiceType.getLastUpdated());
        System.out.println(invoiceType.getStatusRecord());
        System.out.println(invoiceType.getUpdatedBy());

//        invoiceType.setCode("GDXKXPj6");
//        InvoiceType saved = invoiceTypeDao.save(invoiceType);
//        System.out.println(saved.getCode());
//        System.out.println(saved.getUpdatedBy());
//        System.out.println(saved.getLastUpdated());



        assertNotNull(invoiceType.getId());
        assertNotNull(invoiceType.getCode());
        assertNotNull(invoiceType.getName());
        assertNotNull(invoiceType.getCreated());
        assertNotNull(invoiceType.getCreatedBy());
        assertNotNull(invoiceType.getLastUpdated());
        assertNotNull(invoiceType.getUpdatedBy());
        assertNotNull(invoiceType.getStatusRecord());
    }

    @Test
    public void testSoftDelete(){
        testInsert();
        var invoiceType = invoiceTypeDao.findByCode("ipqqssc9yU2");
        invoiceTypeDao.delete(invoiceType);
        var count = invoiceTypeDao.count();
        System.out.println("Jumlah record: " + count);
    }
}
