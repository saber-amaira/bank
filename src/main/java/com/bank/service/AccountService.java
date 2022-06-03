package com.bank.service;

import com.bank.model.Account;
import com.bank.model.Operation;

import javax.naming.OperationNotSupportedException;
import java.math.BigDecimal;
import java.util.Optional;

public interface AccountService {

    Account update(Long id, Operation operation) throws IllegalAccessException;

    Optional<Account> findById(Long id);
}
