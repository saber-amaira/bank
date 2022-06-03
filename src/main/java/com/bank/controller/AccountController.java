package com.bank.controller;

import com.bank.model.Account;
import com.bank.model.Operation;
import com.bank.service.AccountService;
import com.bank.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ControllerAdvice
@RequestMapping("/api/v1/accounts")
public class AccountController {


    @Autowired
    private AccountService accountService;

    @Autowired
    private OperationService operationService;

    @PutMapping("{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable long id, @RequestBody final Operation operation) throws IllegalAccessException {

        Account account = accountService.update(id, operation);

        operationService.save(operation);

        return ResponseEntity.ok(account);
    }

    @GetMapping("{id}/operations")
    public ResponseEntity<List<Operation>> getAccountOperations(@PathVariable long id) {

        return ResponseEntity.ok(operationService.getOperationsByAccountId(id));
    }

}
