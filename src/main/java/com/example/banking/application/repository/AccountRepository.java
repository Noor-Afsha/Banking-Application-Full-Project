package com.example.banking.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.banking.application.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
