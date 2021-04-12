package com.dollarsbank.model;

//Customer model class
public class Customer {
	
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String userId;
	private String password;
	//Stores the cusstomer's account
	private Account account;
	
	public Customer(String firstName, String lastName, String phoneNumber, String userId, String password, double initDeposit) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.userId = userId;
		this.password = password;
		this.setAccount(new Account(initDeposit, userId));
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber
				+ ", userId=" + userId + ", account=" + account + "]";
	}
	
}
