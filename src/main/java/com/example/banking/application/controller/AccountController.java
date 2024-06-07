package com.example.banking.application.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.banking.application.dto.AccountDto;
import com.example.banking.application.service.AccountService;

@RestController
@RequestMapping("/accounts")
@CrossOrigin(origins = "*")
public class AccountController {

	private AccountService accountService;

	// two ways we can autowired the services by using @autowired annotation and
	// second one is by using constructor injection which i have mentioned below for
	// better practice.:-

	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}

	@PostMapping("/add")
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {
		System.out.println("add account method is executed");
		return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
		System.out.println("get by id account method is executed");
		AccountDto accountDto = accountService.getAccountById(id);
		return ResponseEntity.ok(accountDto);
	}

	@PutMapping("/deposit/{id}")
	public ResponseEntity<AccountDto> depositBalance(@PathVariable Long id, @RequestBody Map<String, Double> request) {
		System.out.println("deposit method is excuted");
		AccountDto accountDto = accountService.depositBalance(id, request.get("balance"));
		return ResponseEntity.ok(accountDto);
	}

	@PutMapping("/withdraw/{id}")
	public ResponseEntity<AccountDto> withdrawBalance(@PathVariable Long id, @RequestBody Map<String, Double> request) {
		System.out.println("Withdraw method executed");
		Double balance = request.get("balance");
		AccountDto accountDto = accountService.withdrawBalance(id, balance);
		return ResponseEntity.ok(accountDto);
	}

	@GetMapping("/getAllAccounts")
	public ResponseEntity<List<AccountDto>> getAllAccountDetails() {
		System.out.println("Get all accounts details method is executed");
		List<AccountDto> accountDtos = accountService.getAllAccountDetails();
		return ResponseEntity.ok(accountDtos);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deteleAccounts(@PathVariable Long id) {
		System.out.println("Account delete method executed ");
		accountService.deleteAccounts(id);
		return ResponseEntity.ok("Accounts deleted successfully");
	}
}
