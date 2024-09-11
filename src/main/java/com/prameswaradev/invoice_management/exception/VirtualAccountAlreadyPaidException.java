package com.prameswaradev.invoice_management.exception;

public class VirtualAccountAlreadyPaidException extends Exception{
    public VirtualAccountAlreadyPaidException(String message) {
        super(message);
    }
}
