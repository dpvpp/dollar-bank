package com.dollarsbank.dao;

import com.dollarsbank.model.Customer;

//Customer DAO interface
public interface CustomerDAO {
	
	public Customer addCustomer(Customer customer);
	
	public Customer getCustomerByUserName(String username);
	public boolean existsByUserName(String username);
	
	public Customer updateCustomer(Customer customer);
	
	public boolean deleteCustomerByUserName(String username);
	
}
