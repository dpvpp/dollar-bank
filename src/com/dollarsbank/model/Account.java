package com.dollarsbank.model;

import java.util.ArrayList;
import java.util.List;

public class Account {
	
	private int id;
	private long balance;
	private List<Transaction> transactions;
	private String userId;
	
	public Account() {
		this.balance = 0;
		this.transactions = new ArrayList<Transaction>();
	}
	
	public Account(int id, long balance, String userId) {
		this.id = id;
		this.balance = balance;
		this.transactions = new ArrayList<Transaction>();
		this.userId = userId;
	}
	
	Account(long initBalance, String userId) {
		this.transactions = new ArrayList<Transaction>();
		this.balance = initBalance;
		this.transactions = new ArrayList<Transaction>();
		this.userId = userId;
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
	
	public void setTransaction(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public String getUserId() {
		return userId;
	}

	public int getId() {
		return id;
	}
	
}
