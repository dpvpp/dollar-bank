package com.dollarsbank.model;

import java.time.LocalDateTime;

public class Transaction {
	
	public enum TransType {
		DEPOSIT("deposit"), 
		WITHDRAWAL("withdrawal"), 
		INCOMING_TRANSFER("incoming transfer"), 
		OUTGOING_TRANSFER("outgoing transfer"),
		INITIAL_DEPOSIT("initial deposit");
		
		public final String VALUE;
		
		TransType(String type) {
			this.VALUE = type;
		}
	}
	
	private int id;
	private TransType type;
	private long amount;
	private LocalDateTime date;
	private int accountId;
	
	public Transaction(int id, TransType type, long amount, LocalDateTime date, int accountId) {
		super();
		this.id = id;
		this.type = type;
		this.amount = amount;
		this.date = date;
		this.accountId = accountId;
	}

	public Transaction(TransType type, long amount, int accountId) {
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

	public long getAmount() {
		return amount;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public int getAccountId() {
		return accountId;
	}
	
	
}
