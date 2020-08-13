package com.example.demo.exception;

public class TransactionRefusedException extends Exception {
    public TransactionRefusedException(String message) {
        super(message);
    }
}
