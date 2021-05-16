package com.acc.training.accountapi.repository;

import com.acc.training.accountapi.model.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>  {
    
}