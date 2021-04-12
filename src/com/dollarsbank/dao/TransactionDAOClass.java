package com.dollarsbank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.dollarsbank.connection.ConnectionManager;
import com.dollarsbank.model.Transaction;
import com.dollarsbank.model.Transaction.TransType;
import com.dollarsbank.utility.ConsolePrinterUtility;

public class TransactionDAOClass implements TransactionDAO {
	
	//Queries for the transaction table
	private static final String ADD = "INSERT INTO transaction(trans_type, amount, trans_date, account_id) VALUES (?,?,?,?)";
	private static final String SELECT_BY_ID = "SELECT * FROM transaction WHERE trans_id = ?";
	private static final String SELECT_BY_ACCT = "SELECT * FROM transaction WHERE account_id = ?";
	private static final String DELETE = "DELETE FROM transaction WHERE account_id = ?";
	
	private Connection conn = null;
	
	//Sets up a connection each time the class is instantiated
	public TransactionDAOClass() {
		conn = ConnectionManager.getConnection();
	}
	
	@Override
	//Adds a transaction to the database
	public Transaction addTransaction(Transaction trans) {
		try {
			
			PreparedStatement st = conn.prepareStatement(ADD);
			//JDBC does not support enums so strings are used in the database
			st.setString(1, trans.getType().name());
			st.setDouble(2, trans.getAmount());
			st.setTimestamp(3, Timestamp.valueOf(trans.getDate()));
			st.setInt(4, trans.getAccountId());

			st.execute();
			return trans;
			
		} catch (SQLException e) {
			ConsolePrinterUtility.printSQLError();
			e.printStackTrace();
		}
		return null;
	}

	@Override
	//Gets a transaction by id, never used in this project
	public Transaction getTransactionById(int id) {
		
		Transaction trans = null;
		try {
			
			PreparedStatement st = conn.prepareStatement(SELECT_BY_ID);
			st.setInt(1, id);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				trans = new Transaction(rs.getInt("trans_id"),
										TransType.valueOf(rs.getString("trans_type")), 
										rs.getDouble("amount"), 
										rs.getTimestamp("trans_date").toLocalDateTime(), 
										rs.getInt("account_id"));
			}
			
		} catch (SQLException e) {
			ConsolePrinterUtility.printSQLError();
			e.printStackTrace();
		}
		return trans;
		
	}

	@Override
	//Gets all the transactions for an account, primary way of getting the transactions
	public List<Transaction> getTransActionsByAccountId(int id) {
		
		List<Transaction> transactions = new ArrayList<Transaction>();
		try {
			
			PreparedStatement st = conn.prepareStatement(SELECT_BY_ACCT);
			st.setInt(1, id);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				transactions.add(new Transaction(rs.getInt("trans_id"),
										         TransType.valueOf(rs.getString("trans_type")), 
										         rs.getDouble("amount"), 
										         rs.getTimestamp("trans_date").toLocalDateTime(), 
										         rs.getInt("account_id")));
			}
			
		} catch (SQLException e) {
			ConsolePrinterUtility.printSQLError();
			e.printStackTrace();
		}
		return transactions;
		
	}

	@Override
	//delete transactions from database using account id, it is not used
	public boolean deleteTransactionById(int id) {

		try {
			
			PreparedStatement st = conn.prepareStatement(DELETE);
			st.setInt(1, id);
			
			st.execute();
			return true;
			
		} catch (SQLException e) {
			ConsolePrinterUtility.printSQLError();
			e.printStackTrace();
		}
		return false;

	}

}
