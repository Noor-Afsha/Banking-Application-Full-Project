package com.example.banking.application.mapper;

import com.example.banking.application.dto.AccountDto;
import com.example.banking.application.entity.Account;

public class AccountMapper {

	public static Account mapToAccount(AccountDto accountDto) {
		Account account = new Account(
				accountDto.getId(), 
				accountDto.getAccountHolderName(), 
				accountDto.getAge(),
				accountDto.getMobileNumber(), 
				accountDto.getAccountType(), 
				accountDto.getBalance());
		return account;
	}

	public static AccountDto mapToAccountDto(Account account) {
		AccountDto accountDto = new AccountDto(
				account.getId(),
				account.getAccountHolderName(),
				account.getAge(), 
				account.getMobileNumber(),
				account.getAccountType(),
				account.getBalance());
		return accountDto;
	}
}