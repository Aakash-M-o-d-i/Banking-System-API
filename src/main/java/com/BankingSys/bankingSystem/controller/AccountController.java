package com.BankingSys.bankingSystem.controller;

import com.BankingSys.bankingSystem.Account;
import com.BankingSys.bankingSystem.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map; // it is basically hashmap or array type

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    // this method is connected with service sector for manage the creating account
    @PostMapping
    public Account createAccount(@RequestBody Account account){
        return accountService.createAccount(account);
    }

    // this method check the "Id" is null or not
    @GetMapping("/{id}")
    public Account getAccount(@PathVariable Long id){
        return accountService.getAccount(id).orElseThrow(() -> new RuntimeException("Account not found!"));
    }

    // In this method help to deposit amount
    // basically this Map help to change the one datatype to another datatype like in here String to Double
    @PostMapping("/{id}/deposit")
    public Account deposit(@PathVariable Long id, @RequestBody Map<String, Double> request){
        Double amountDep = request.get("amount");
        return accountService.deposit(id, amountDep);
    }
    @PostMapping("/{id}/withdraw")
    public Account withdraw(@PathVariable Long id, @RequestBody Map<String,Double> request){
        Double amountWith = request.get("amount");
        return accountService.withdraw(id,amountWith);
    }




}
