package com.dollarsbank.model;

import java.util.Date;

public class Transaction {
	
	public enum TransType {
		DEPOSIT("deposit"), WITHDRAWAL("withdrawal"), INCOMING_TRANSFER("incoming transfer"), OUTGOING_TRANSFER("outgoing transfer");
		
		public final String VALUE;
		
		TransType(String type) {
			this.VALUE = type;
		}
	}
	
	private int id;
	private TransType type;
	private long amount;
	private Date date;
	private int accountId;
	
	public Transaction(int id, TransType type, long amount, int accountId) {
		super();
		this.id = id;
		this.type = type;
		this.amount = amount;
		this.date = new Date();
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

	public Date getDate() {
		return date;
	}

	public int getAccountId() {
		return accountId;
	}
	
	
}
