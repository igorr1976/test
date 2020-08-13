package com.example.demo.service;

import com.example.demo.exception.TransactionRefusedException;
import com.example.demo.model.Transaction;
import com.example.demo.model.TransactionBody;
import com.example.demo.model.User;


public interface TransactionService {
    Transaction transaction(User user, TransactionBody transactionBody) throws TransactionRefusedException;
}

