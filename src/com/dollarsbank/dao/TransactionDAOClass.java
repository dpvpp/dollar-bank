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

	private static final String ADD = "INSERT INTO transaction(trans_type, amount, trans_date, account_id) VALUES (?,?,?,?)";
	private static final String SELECT_BY_ID = "SELECT * FROM transaction WHERE trans_id = ?";
	private static final String SELECT_BY_ACCT = "SELECT * FROM transaction WHERE account_id = ?";
	private static final String DELETE = "DELETE FROM transaction WHERE account_id = ?";
	
	private Connection conn = null;
	
	public TransactionDAOClass() {
		conn = ConnectionManager.getConnection();
	}
	
	@Override
	public Transaction addTransaction(Transaction trans) {
		try {
			
			PreparedStatement st = conn.prepareStatement(ADD);
			st.setString(1, trans.getType().VALUE);
			st.setLong(2, trans.getAmount());
			st.setTimestamp(3, Timestamp.valueOf(trans.getDate()));
			st.setInt(4, trans.getAccountId());
			
			if(st.execute()) {
				return trans;
			}
			
		} catch (SQLException e) {
			ConsolePrinterUtility.printSQLError();
		}
		return null;
	}

	@Override
	public Transaction getTransactionById(int id) {
		
		Transaction trans = null;
		try {
			
			PreparedStatement st = conn.prepareStatement(SELECT_BY_ID);
			st.setLong(1, id);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				trans = new Transaction(rs.getInt("trans_id"),
										TransType.valueOf(rs.getString("trans_type")), 
										rs.getLong("amount"), 
										rs.getTimestamp("trans_time").toLocalDateTime(), 
										rs.getInt("account_id"));
			}
			
		} catch (SQLException e) {
			ConsolePrinterUtility.printSQLError();
		}
		return trans;
		
	}

	@Override
	public List<Transaction> getTransActionsByAccountId(int id) {
		
		List<Transaction> transactions = new ArrayList<Transaction>();
		try {
			
			PreparedStatement st = conn.prepareStatement(SELECT_BY_ACCT);
			st.setLong(1, id);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				transactions.add(new Transaction(rs.getInt("trans_id"),
										         TransType.valueOf(rs.getString("trans_type")), 
										         rs.getLong("amount"), 
										         rs.getTimestamp("trans_time").toLocalDateTime(), 
										         rs.getInt("account_id")));
			}
			
		} catch (SQLException e) {
			ConsolePrinterUtility.printSQLError();
		}
		return transactions;
		
	}

	@Override
	public boolean deleteTranactionById(int id) {

		try {
			
			PreparedStatement st = conn.prepareStatement(DELETE);
			st.setInt(1, id);
			
			return st.execute();
			
		} catch (SQLException e) {
			ConsolePrinterUtility.printSQLError();
		}
		return false;

	}

}
