package com.dollarsbank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dollarsbank.connection.ConnectionManager;
import com.dollarsbank.model.Customer;
import com.dollarsbank.utility.ConsolePrinterUtility;

public class CustomerDAOClass implements CustomerDAO{

	private static final String ADD = "INSERT INTO customer(username, cust_pw, firstname, lastname, phone) VALUES (?,?,?,?,?)";
	private static final String SELECT_BY_ID = "SELECT * FROM customer WHERE username = ?";
	private static final String UPDATE = "UPDATE customer SET username = ?, cust_pw = ?, firstname = ?, lastname = ?, phone = ? WHERE username = ?";
	private static final String DELETE = "DELETE FROM customer WHERE  username = ?";
	
	private Connection conn = null;
	
	public CustomerDAOClass() {
		conn = ConnectionManager.getConnection();
	}
	
	@Override
	public Customer addCustomer(Customer customer) {
		
		try {
			
			PreparedStatement st = conn.prepareStatement(ADD);
			st.setString(1, customer.getUserId());
			st.setString(2, customer.getPassword());
			st.setString(3, customer.getFirstName());
			st.setString(4, customer.getLastName());
			st.setString(5, customer.getPhoneNumber());
			
			if(st.execute()) {
				return customer;
			}
			
		} catch (SQLException e) {
			ConsolePrinterUtility.printSQLError();
		}
		return null;
		
	}

	@Override
	public Customer getCustomerByUserName(String username) {
		
		Customer customer = null;
		try {
			
			PreparedStatement st = conn.prepareStatement(SELECT_BY_ID);
			st.setString(1, username);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				customer = new Customer(rs.getString("firstname"), 
										rs.getString("lastname"), 
										rs.getString("phone"), 
										rs.getNString("username"), 
										rs.getString("cust_pw"), 0);
			}
			
		} catch (SQLException e) {
			ConsolePrinterUtility.printSQLError();
		}
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		
		try {
			
			PreparedStatement st = conn.prepareStatement(UPDATE);
			st.setString(1, customer.getUserId());
			st.setString(2, customer.getPassword());
			st.setString(3, customer.getFirstName());
			st.setString(4, customer.getLastName());
			st.setString(5, customer.getPhoneNumber());
			
			if(st.execute()) {
				return customer;
			}
			
		} catch (SQLException e) {
			ConsolePrinterUtility.printSQLError();
		}
		return null;
		
	}

	@Override
	public boolean deleteCustomerByUserName(String username) {
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
