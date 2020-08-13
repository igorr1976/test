package com.example.demo.controller;

import com.example.demo.exception.TransactionRefusedException;
import com.example.demo.model.Transaction;
import com.example.demo.model.TransactionBody;
import com.example.demo.model.User;
import com.example.demo.service.TransactionService;
import com.example.demo.service.TransactionServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TransactionController {

    private final Logger log = LoggerFactory.getLogger(TransactionController.class);

    private final User user = new User(1L, "Igor", "test@gmail.com");

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/v1/transaction")
    ResponseEntity<Transaction> transactionNew(@RequestBody TransactionBody transactionBody) {
        log.debug("transactionBody : ", transactionBody);
        ResponseEntity responseEntity;
        try {

            Transaction transaction = transactionService.transaction(user, transactionBody);

            log.debug("transaction : ", transaction);

            responseEntity = ResponseEntity.ok().body(transaction);

        } catch (TransactionRefusedException e) {
            log.error("Transaction error ", e);

            responseEntity = ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(e.getLocalizedMessage());
        }
        return responseEntity;
    }

    @GetMapping("/v1/transactions")
    Collection<Transaction> transactionHistory() {
        return user.getTransactions();
    }

    @GetMapping("/v1/transaction/{id}")
    ResponseEntity<?> getTransaction(@PathVariable String id) {
        Optional<Transaction> transaction = user.getTransactions().stream().filter(tr -> tr.getId().equals(id)).findFirst();
        return transaction.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
