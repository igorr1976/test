package com.example.demo.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Getter
@Setter
public class Transaction {
    private String          id;
    private TransactionType type;
    private BigDecimal      amount;
    private LocalDateTime   effectiveDate;

}
