package com.dollarsbank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dollarsbank.connection.ConnectionManager;
import com.dollarsbank.model.Account;
import com.dollarsbank.utility.ConsolePrinterUtility;

public class AccountDAOClass implements AccountDAO {

	private static final String ADD = "INSERT INTO cust_account(balance, username) VALUES (?,?)";
	private static final String SELECT_BY_ID = "SELECT * FROM cust_account WHERE account_id = ?";
	private static final String SELECT_BY_USER = "SELECT * FROM cust_account WHERE username = ?";
	private static final String UPDATE = "UPDATE cust_id SET balance = ? WHERE username = ?";
	private static final String DELETE = "DELETE FROM cust_id WHERE  username = ?";
	
	private Connection conn = null;
	
	public AccountDAOClass() {
		conn = ConnectionManager.getConnection();
	}
	
	
	@Override
	public Account addAccount(Account account) {
		
		try {
			
			PreparedStatement st = conn.prepareStatement(ADD);
			st.setLong(1, account.getBalance());
			st.setString(2, account.getUserId());
			
			if(st.execute()) {
				return account;
			}
			
		} catch (SQLException e) {
			ConsolePrinterUtility.printSQLError();
		}
		return null;
		
	}

	@Override
	public Account getAccountById(int id) {
		
		Account account = null;
		try {
			
			PreparedStatement st = conn.prepareStatement(SELECT_BY_ID);
			st.setLong(1, id);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				account = new Account(rs.getLong("balance"), rs.getString("username"));
			}
			
		} catch (SQLException e) {
			ConsolePrinterUtility.printSQLError();
		}
		return account;
		
	}

	@Override
	public Account getAccountByUserName(String username) {
		
		Account account = null;
		try {
			
			PreparedStatement st = conn.prepareStatement(SELECT_BY_USER);
			st.setString(1, username);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				account = new Account(rs.getLong("balance"), rs.getString("username"));
			}
			
		} catch (SQLException e) {
			ConsolePrinterUtility.printSQLError();
		}
		return account;
		
	}

	@Override
	public Account updateAccount(Account account) {
		
		try {
			
			PreparedStatement st = conn.prepareStatement(UPDATE);
			st.setString(1, account.getUserId());
			
			if(st.execute()) {
				return account;
			}
			
		} catch (SQLException e) {
			ConsolePrinterUtility.printSQLError();
		}
		return null;
		
	}

	@Override
	public boolean deleteAccountByUser(String username) {
		
		try {
			
			PreparedStatement st = conn.prepareStatement(DELETE);
			st.setString(1, username);
			
			return st.execute();
			
		} catch (SQLException e) {
			ConsolePrinterUtility.printSQLError();
		}
		return false;
		
	}

}
