package com.dollarsbank.model;

import java.time.LocalDateTime;

public class Transaction {
	
	public enum TransType {
		DEPOSIT("Deposit"), 
		WITHDRAWAL("Withdrawal"), 
		INCOMING_TRANSFER("Incoming transfer"), 
		OUTGOING_TRANSFER("Outgoing transfer"),
		INITIAL_DEPOSIT("Initial deposit");
		
		public final String VALUE;
		
		TransType(String type) {
			this.VALUE = type;
		}
	}
	
	private int id;
	private TransType type;
	private double amount;
	private LocalDateTime date;
	private int accountId;
	
	public Transaction(int id, TransType type, double amount, LocalDateTime date, int accountId) {
		super();
		this.id = id;
		this.type = type;
		this.amount = amount;
		this.date = date;
		this.accountId = accountId;
	}

	public Transaction(TransType type, double amount, int accountId) {
		super();
		this.type = type;
		this.amount = amount;
		this.date = LocalDateTime.now();
		this.accountId = accountId;
	}
	
	public int getId() {
		return id;
	}

	public TransType getType() {
		return type;
	}

	public double getAmount() {
		return amount;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public int getAccountId() {
		return accountId;
	}
	
	
}
