package com.example.demo.model;

import com.example.demo.exception.TransactionRefusedException;
import lombok.*;

import java.math.BigDecimal;
import java.rmi.server.UID;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Account {

    private BigDecimal balance = new BigDecimal(0);

    public synchronized Transaction transaction(TransactionBody transactionBody) throws TransactionRefusedException {

        switch (transactionBody.getType()){
            case DEBIT:


                balance = balance.add(transactionBody.getAmount());
                break;
            case CREDIT:
                if(transactionBody.getAmount().compareTo(balance)>0){
                    throw new TransactionRefusedException(String.format("Transaction refused. Operation %s sum %s. Balance %s ",
                            transactionBody.getType().name(),
                            transactionBody.getAmount(), balance));

                }
                balance = balance.subtract(transactionBody.getAmount());
                break;
        }

        String id = UUID.randomUUID().toString();

        Transaction transaction = new Transaction(id, transactionBody.getType(), transactionBody.getAmount(), LocalDateTime.now());

        return transaction;
    }
}
