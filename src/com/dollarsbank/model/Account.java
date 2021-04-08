package com.dollarsbank.model;

import java.util.ArrayList;
import java.util.List;

public class Account {
	
	private long balance;
	private List<Transaction> transactions;
	
	Account() {
		this.balance = 0;
		this.transactions = new ArrayList<Transaction>();
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
	
	public void addTransaction(Transaction trans) {
		transactions.add(trans);
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}
	
}
