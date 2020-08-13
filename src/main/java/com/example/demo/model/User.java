package com.example.demo.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;

@Getter
@Setter
public class User {

    private Long id;
    private String name;
    private String email;
    private final Account account;
    private final List<Transaction> transactions;

    public User(Long id, String name, String email){
        this();
        this.id=id;
        this.name=name;
        this.email = email;
    }

    public User(){
        account = new Account();
        transactions = new CopyOnWriteArrayList<>();
    }

}
