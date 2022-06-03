package com.bank.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Data
public class Operation {

    private Long id;

    private OperationType type;

    private BigDecimal amount;

    private LocalDateTime createdAt;

}
