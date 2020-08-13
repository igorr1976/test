package com.example.demo.service;

import com.example.demo.exception.TransactionRefusedException;
import com.example.demo.model.Transaction;
import com.example.demo.model.TransactionBody;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Override
    public Transaction transaction(User user, TransactionBody transactionBody) throws TransactionRefusedException {

        Transaction transaction = user.getAccount().transaction(transactionBody);
        user.getTransactions().add(transaction);

        return transaction;
    }

}
