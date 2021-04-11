package com.dollarsbank.controller;

import com.dollarsbank.dao.AccountDAO;
import com.dollarsbank.dao.AccountDAOClass;
import com.dollarsbank.dao.CustomerDAO;
import com.dollarsbank.dao.CustomerDAOClass;
import com.dollarsbank.dao.TransactionDAO;
import com.dollarsbank.dao.TransactionDAOClass;
import com.dollarsbank.model.Account;
import com.dollarsbank.model.Customer;
import com.dollarsbank.model.Transaction;
import com.dollarsbank.model.Transaction.TransType;

public class DollarsBankController {
	
	CustomerDAO custDAO;
	AccountDAO acctDAO;
	TransactionDAO transDAO;
	
	public DollarsBankController() {
		custDAO = new CustomerDAOClass();
		acctDAO = new AccountDAOClass();
		transDAO = new TransactionDAOClass();
	}
	
	public Customer createCustomer(String firstName, String lastName, String phoneNumber, String userId, String password, double initDeposit) {
		
		Customer customer = new Customer(firstName, lastName, phoneNumber, userId, password, initDeposit);
		
		customer = custDAO.addCustomer(customer);
		Account acct = acctDAO.addAccount(customer.getAccount());
		transDAO.addTransaction(new Transaction(TransType.INITIAL_DEPOSIT, initDeposit, acct.getId()));
		acct.setTransaction(transDAO.getTransActionsByAccountId(acct.getId()));
		customer.setAccount(acct);
		
		return customer;
		
	}
	
	public Customer getCustomer(String username, String password) {
		
		Customer customer = custDAO.getCustomerByUserName(username);
		
		if(customer != null) {
			if(!customer.getPassword().equals(password)) {
				customer = null;
			} else {
				Account acct = acctDAO.getAccountByUserName(username);;
				acct.setTransaction(transDAO.getTransActionsByAccountId(acct.getId()));
				customer.setAccount(acct);
			}
		} 
		
		return customer;
		
	}
	
	public Customer updateCustomer(Customer customer) {
		
		if(checkIfUsernameExists(customer.getUserId())) {
			return custDAO.updateCustomer(customer);
		}
		return null;
		
	}
	
	public boolean deleteCustomer(String username, String password) {
		
		Customer customer = custDAO.getCustomerByUserName(username);
		
		if(customer != null) {
			if(!customer.getPassword().equals(password)) {
				return false;
			} else {
				Account acct = acctDAO.getAccountByUserName(username);;
				transDAO.deleteTranactionById(acct.getId());
				acctDAO.deleteAccountByUser(username);
				return custDAO.deleteCustomerByUserName(username);
			}
		} 
		return false;
	}
	
	public Account getAccount(String username) {
		return acctDAO.getAccountByUserName(username);
	}
	
	public Account deposit(Account acct, double amount) {
		
		acct.deposit(amount);
		
		acct = acctDAO.updateAccount(acct);
		transDAO.addTransaction(new Transaction(TransType.DEPOSIT, amount, acct.getId()));
		acct.setTransaction(transDAO.getTransActionsByAccountId(acct.getId()));
		
		return acct;
		
	}
	
	public Account withdraw(Account acct, double amount) {
		
		acct.withdraw(amount);
		
		acct = acctDAO.updateAccount(acct);
		transDAO.addTransaction(new Transaction(TransType.WITHDRAWAL, amount, acct.getId()));
		acct.setTransaction(transDAO.getTransActionsByAccountId(acct.getId()))
		;
		return acct;
		
	}
	
	public Account transfer(Account acct1, Account acct2, double amount) {
		
		acct1.withdraw(amount);
		acct2.deposit(amount);
		
		acct1 = acctDAO.updateAccount(acct1);
		transDAO.addTransaction(new Transaction(TransType.OUTGOING_TRANSFER, amount, acct1.getId()));
		acct1.setTransaction(transDAO.getTransActionsByAccountId(acct1.getId()));
		
		acct2 = acctDAO.updateAccount(acct2);
		transDAO.addTransaction(new Transaction(TransType.INCOMING_TRANSFER, amount, acct2.getId()));
		acct2.setTransaction(transDAO.getTransActionsByAccountId(acct2.getId()));
		
		return acct1;
		
	}
	
	public boolean checkIfUsernameExists(String username) {
		return custDAO.existsByUserName(username);
	}
	
}
