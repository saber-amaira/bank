package com.bank.service.impl;

import com.bank.model.Account;
import com.bank.model.Operation;
import com.bank.model.OperationType;
import com.bank.service.AccountService;

import java.math.BigDecimal;
import java.util.Optional;

public class AccountServiceImpl implements AccountService {

    @Override
    public Account update(Long id, Operation operation) {
        Account account = findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Account doesn't exist with id: " + id));

        BigDecimal actualBalance = account.getBalance();
        if (operation.getType() == OperationType.Deposit) {
            account.setBalance(actualBalance.add(operation.getAmount()));
        } else if (operation.getType() == OperationType.Withdrawal && actualBalance.compareTo(operation.getAmount()) >= 0) {
            account.setBalance(actualBalance.subtract(operation.getAmount()));
        } else {
            throw new IllegalArgumentException("Operation not allowed with amount " + operation.getAmount());
        }
        // repository call saveOrUpdate
        return account;
    }

    @Override
    public Optional<Account> findById(Long id) {
        // repository call findById
        return Optional.empty();
    }
}
