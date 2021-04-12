package com.dollarsbank.dao;

import java.util.List;

import com.dollarsbank.model.Transaction;

//Transaction DAO interface
public interface TransactionDAO {
	
	public Transaction addTransaction(Transaction trans);
	
	public Transaction getTransactionById(int id);
	public List<Transaction> getTransActionsByAccountId(int id);
	
	//Transactions will never be updated
	
	public boolean deleteTransactionById(int id);
	
}
