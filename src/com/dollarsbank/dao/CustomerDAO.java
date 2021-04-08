package com.dollarsbank.dao;

import com.dollarsbank.model.Customer;

public interface CustomerDAO {
	
	public Customer addCustomer(Customer customer);
	
	public Customer getCustomerByUserName(String username);
	
	public Customer updateCustomer(Customer customer);
	
	public boolean deleteCustomerByUserName(String username);
	
}
