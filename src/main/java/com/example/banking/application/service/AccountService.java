package com.example.banking.application.service;

import java.util.List;

import com.example.banking.application.dto.AccountDto;

public interface AccountService {

	AccountDto createAccount(AccountDto accountDto);

	AccountDto getAccountById(Long id);

	AccountDto depositBalance(Long id, double balance);

	AccountDto withdrawBalance(Long id, double balance);

	List<AccountDto> getAllAccountDetails();

	AccountDto deleteAccounts(Long id);
}
