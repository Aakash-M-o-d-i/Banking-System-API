package com.BankingSys.bankingSystem.repository;

import com.BankingSys.bankingSystem.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// it will get perform CRUD database operations on "Account" entity.
public interface AccountRepository extends JpaRepository<Account, Long> {

}

