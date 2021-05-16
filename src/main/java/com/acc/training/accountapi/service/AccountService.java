package com.acc.training.accountapi.service;

import java.util.List;

import com.acc.training.accountapi.model.Account;
import com.acc.training.accountapi.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    public List<Account> findAllAccounts() {
        return repository.findAll();
    }

    public Account saveAccount(Account account) {
        return repository.save(account);
    }
    
}
