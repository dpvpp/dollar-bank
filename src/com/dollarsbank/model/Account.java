package com.dollarsbank.model;

import java.util.ArrayList;
import java.util.List;

public class Account {
	
	private int id;
	private double balance;
	private List<Transaction> transactions;
	private String userId;
	
	public Account() {
		this.balance = 0;
		this.transactions = new ArrayList<Transaction>();
	}
	
	public Account(int id, double balance, String userId) {
		this.id = id;
		this.balance = balance;
		this.transactions = new ArrayList<Transaction>();
		this.userId = userId;
	}
	
	Account(double initBalance, String userId) {
		this.transactions = new ArrayList<Transaction>();
		this.balance = initBalance;
		this.transactions = new ArrayList<Transaction>();
		this.userId = userId;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public double withdraw(double amount) {
		this.balance -= amount;
		return amount;
	}
	
	public void deposit(double amount) {
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
