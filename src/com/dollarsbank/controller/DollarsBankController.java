package com.dollarsbank.controller;

import java.util.ArrayList;
import java.util.List;

import com.dollarsbank.model.Customer;

public class DollarsBankController {

	public static List<Customer> customers = new ArrayList<Customer>();
	
	public static Customer createCustomer(String firstName, String lastName, String phoneNumber, String userId, String password) {
		
		Customer customer = new Customer(firstName, lastName, phoneNumber, userId, password);
		customers.add(customer);
		return customer;
		
	}
	
}
