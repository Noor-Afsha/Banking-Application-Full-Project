package com.example.banking.application.dto;

public class AccountDto {

	private Long id;
	private String accountHolderName;
	private String age;
	private String mobileNumber;
	private String accountType;
	private double balance;

	public AccountDto() {
		super();
	}

	public AccountDto(Long id, String accountHolderName, String age, String mobileNumber, String accountType,
			double balance) {
		super();
		this.id = id;
		this.accountHolderName = accountHolderName;
		this.age = age;
		this.mobileNumber = mobileNumber;
		this.accountType = accountType;
		this.balance = balance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "AccountDto [id=" + id + ", accountHolderName=" + accountHolderName + ", age=" + age + ", mobileNumber="
				+ mobileNumber + ", accountType=" + accountType + ", balance=" + balance + "]";
	}

}
