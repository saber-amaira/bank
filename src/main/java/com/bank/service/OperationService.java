package com.bank.service;

import com.bank.model.Operation;

import java.util.List;

public interface OperationService {

    void save(Operation operation);

    List<Operation> getOperationsByAccountId(Long accountId);
}
