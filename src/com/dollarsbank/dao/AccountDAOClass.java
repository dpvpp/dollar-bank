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
	private static final String UPDATE = "UPDATE cust_account SET balance = ? WHERE username = ?";
	private static final String DELETE = "DELETE FROM cust_account WHERE  username = ?";
	
	private Connection conn = null;
	
	public AccountDAOClass() {
		conn = ConnectionManager.getConnection();
	}
	
	
	@Override
	public Account addAccount(Account account) {
		
		try {
			
			PreparedStatement st = conn.prepareStatement(ADD);
			st.setDouble(1, account.getBalance());
			st.setString(2, account.getUserId());
			
			st.execute();
			return getAccountByUserName(account.getUserId());
			
		} catch (SQLException e) {
			ConsolePrinterUtility.printSQLError();
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public Account getAccountById(int id) {
		
		Account account = null;
		try {
			
			PreparedStatement st = conn.prepareStatement(SELECT_BY_ID);
			st.setInt(1, id);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				account = new Account(rs.getInt("account_id"), rs.getDouble("balance"), rs.getString("username"));
			}
			
		} catch (SQLException e) {
			ConsolePrinterUtility.printSQLError();
			e.printStackTrace();
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
				account = new Account(rs.getInt("account_id"), rs.getDouble("balance"), rs.getString("username"));
			}
			
		} catch (SQLException e) {
			ConsolePrinterUtility.printSQLError();
			e.printStackTrace();
		}
		return account;
		
	}

	@Override
	public Account updateAccount(Account account) {
		
		try {
			
			PreparedStatement st = conn.prepareStatement(UPDATE);
			st.setDouble(1, account.getBalance());
			st.setString(2, account.getUserId());

			st.execute();
			return account;
			
		} catch (SQLException e) {
			ConsolePrinterUtility.printSQLError();
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public boolean deleteAccountByUser(String username) {
		
		try {
			
			PreparedStatement st = conn.prepareStatement(DELETE);
			st.setString(1, username);
			
			st.execute();
			return true;
			
		} catch (SQLException e) {
			ConsolePrinterUtility.printSQLError();
			e.printStackTrace();
		}
		return false;
		
	}

}
