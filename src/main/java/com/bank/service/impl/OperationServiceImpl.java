package com.bank.service.impl;

import com.bank.model.Operation;
import com.bank.service.OperationService;

import java.util.ArrayList;
import java.util.List;

public class OperationServiceImpl implements OperationService {
    @Override
    public List<Operation> getOperationsByAccountId(Long accountId) {
        // repository call getByAccountId
        return new ArrayList<>();
    }
}
