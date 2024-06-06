package com.example.banking.application.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.banking.application.dto.AccountDto;
import com.example.banking.application.entity.Account;
import com.example.banking.application.mapper.AccountMapper;
import com.example.banking.application.repository.AccountRepository;
import com.example.banking.application.service.AccountService;

@Service
public class AccountServicesImpl implements AccountService {

	private AccountRepository accountRepository;
	// here we can inject the repository by two
	// 1. by using @Autowired
	// 2.by using construction so better to use by constructor way..as i have done
	// below:-

	public AccountServicesImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}

	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		Account account = AccountMapper.mapToAccount(accountDto);
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto getAccountById(Long id) {
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Account with this id not found:-" + id));
		return AccountMapper.mapToAccountDto(account);
	}

	@Override
	public AccountDto depositBalance(Long id, double balance) {
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exists"));
		double totalBalance = account.getBalance() + balance;
		account.setBalance(totalBalance);
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto withdrawBalance(Long id, double balance) {
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exits"));
		if (account.getBalance() < balance) {
			throw new RuntimeException("Insufficient Balance");
		}
		double totalBalance = account.getBalance() - balance;
		account.setBalance(totalBalance);
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public List<AccountDto> getAllAccountDetails() {
		return accountRepository.findAll().stream().map((account) -> AccountMapper.mapToAccountDto(account))
				.collect(Collectors.toList());
	}

	@Override
	public AccountDto deleteAccounts(Long id) {
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exists"));
		accountRepository.delete(account);
		return null;
	}

}
