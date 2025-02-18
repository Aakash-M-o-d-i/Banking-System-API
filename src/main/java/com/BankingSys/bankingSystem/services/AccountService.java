package com.BankingSys.bankingSystem.services;

import com.BankingSys.bankingSystem.Account;
import com.BankingSys.bankingSystem.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    // this is for connecting between the service layer to account layer
    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    // this method create the user account
    public Account createAccount(Account account){
        return accountRepository.save(account);
    }

    // this method get the account id
    public Optional<Account> getAccount(Long id){ // Optional help to not null in value
        return accountRepository.findById(id);
    }

    // IN this method basically add the money
    public Account deposit(Long id, double amount){
        // if the ID is empty then it => throw the RuntimeException
        Account accountDep = getAccount(id).orElseThrow(() -> new RuntimeException("Account not found"));
        accountDep.setBalance(accountDep.getBalance() + amount);
        return accountRepository.save(accountDep); // this will be responsible for db
    }

    // in this method basically withdraw the money
    public Account withdraw(Long id, double amount){
        Account accountWith = getAccount(id).orElseThrow(() -> new RuntimeException("Account not found"));
        if(accountWith.getBalance() < amount){
            throw new RuntimeException("Insufficient balance");
        }
        accountWith.setBalance(accountWith.getBalance() - amount);
        return accountRepository.save(accountWith);
    }


}
