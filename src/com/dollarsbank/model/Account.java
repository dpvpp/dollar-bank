package com.dollarsbank.model;

import java.util.ArrayList;
import java.util.List;

//Account model class
public class Account {
	
	private int id;
	private double balance;
	//List that contains all the transactions
	private List<Transaction> transactions;
	//UserId is the primary way of finding account
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
	
	//Since sometimes accounts need to made without ids this constructor is necessary
	Account(double initBalance, String userId) {
		this.transactions = new ArrayList<Transaction>();
		this.balance = initBalance;
		this.transactions = new ArrayList<Transaction>();
		this.userId = userId;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	//Balance is set by deposits and withdrawals
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

	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + ", transactions=" + transactions + ", userId=" + userId
				+ "]";
	}
	
}
