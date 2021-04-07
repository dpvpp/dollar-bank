package com.dollarsbank.controller;

import java.util.ArrayList;
import java.util.List;

import com.dollarsbank.model.Customer;

public class DollarsBankController {

	public List<Customer> customers = new ArrayList<Customer>();
	
	public Customer createCustomer(String firstName, String lastName, String phoneNumber, String userId, String password, long initDeposit) {
		
		Customer customer = new Customer(firstName, lastName, phoneNumber, userId, password, initDeposit);
		customers.add(customer);
		return customer;
		
	}
	
}
