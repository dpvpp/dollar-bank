package com.dollarsbank.model;

public class Account {
	
	private long balance;
	
	Account() {
		this.balance = 0;
	}
	
	Account(long initBalance) {
		this.balance = initBalance;
	}
	
	public long getBalance() {
		return this.balance;
	}
	
	public long withdraw(long amount) {
		this.balance -= amount;
		return amount;
	}
	
	public void deposit(long amount) {
		this.balance += amount;
	}
	
}
