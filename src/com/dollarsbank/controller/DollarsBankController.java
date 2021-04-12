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
	
	//Data access objects
	CustomerDAO custDAO;
	AccountDAO acctDAO;
	TransactionDAO transDAO;
	
	//Initiate DAOs when new instance is created
	public DollarsBankController() {
		custDAO = new CustomerDAOClass();
		acctDAO = new AccountDAOClass();
		transDAO = new TransactionDAOClass();
	}
	
	//Create user
	public Customer createCustomer(String firstName, String lastName, String phoneNumber, String userId, String password, double initDeposit) {
		
		//Create user and add to database
		Customer customer = new Customer(firstName, lastName, phoneNumber, userId, password, initDeposit);
		customer = custDAO.addCustomer(customer);
		
		//Store account in a variable to add to the database
		Account acct = acctDAO.addAccount(customer.getAccount());
		
		//Add initial deposit transaction to database
		transDAO.addTransaction(new Transaction(TransType.INITIAL_DEPOSIT, initDeposit, acct.getId()));
		
		//Update account with transaction and add to database, update customer with new account 
		acct.setTransaction(transDAO.getTransActionsByAccountId(acct.getId()));
		customer.setAccount(acct);
		
		return customer;
		
	}
	
	//Get customer, needs username and password
	public Customer getCustomer(String username, String password) {
		
		//Query database
		Customer customer = custDAO.getCustomerByUserName(username);
		
		//Customer does not exist if DAO returns null
		if(customer != null) {
			//Make sure password is the same
			if(!customer.getPassword().equals(password)) {
				customer = null;
			} else {
				//Set up account with transactions from db and update customer object
				Account acct = acctDAO.getAccountByUserName(username);;
				acct.setTransaction(transDAO.getTransActionsByAccountId(acct.getId()));
				customer.setAccount(acct);
			}
		} 
		
		return customer;
		
	}
	
	//Update customer
	public Customer updateCustomer(Customer customer) {
		
		//Make sure that customer exists before update
		if(checkIfUsernameExists(customer.getUserId())) {
			return custDAO.updateCustomer(customer);
		}
		return null;
		
	}
	
	//delete customer needs username and password
	public boolean deleteCustomer(String username, String password) {
		
		Customer customer = custDAO.getCustomerByUserName(username);
		
		if(customer != null) {
			if(!customer.getPassword().equals(password)) {
				return false;
			} else {
				//Must delete account and transaction before customer is deleted
				Account acct = acctDAO.getAccountByUserName(username);;
				transDAO.deleteTransactionById(acct.getId());
				acctDAO.deleteAccountByUser(username);
				return custDAO.deleteCustomerByUserName(username);
			}
		} 
		return false;
	}
	
	//Gets an account based on the username from database
	public Account getAccount(String username) {
		return acctDAO.getAccountByUserName(username);
	}
	
	//Performs deposit 
	public Account deposit(Account acct, double amount) {
		
		//Update account object with deposit
		acct.deposit(amount);
		
		//Update account in database and add a new transaction
		acct = acctDAO.updateAccount(acct);
		transDAO.addTransaction(new Transaction(TransType.DEPOSIT, amount, acct.getId()));
		acct.setTransaction(transDAO.getTransActionsByAccountId(acct.getId()));
		
		return acct;
		
	}
	
	//Performs withdraw, follows the same steps as deposit
	public Account withdraw(Account acct, double amount) {
		
		acct.withdraw(amount);
		
		acct = acctDAO.updateAccount(acct);
		transDAO.addTransaction(new Transaction(TransType.WITHDRAWAL, amount, acct.getId()));
		acct.setTransaction(transDAO.getTransActionsByAccountId(acct.getId()))
		;
		return acct;
		
	}
	
	//Transfers funds from one account to the other using a username
	public Account transfer(Account acct1, Account acct2, double amount) {
		
		//Performs a withdraw on account 1 and a deposit on account 2
		acct1.withdraw(amount);
		acct2.deposit(amount);
		
		//Adds new transactions to both accounts
		acct1 = acctDAO.updateAccount(acct1);
		transDAO.addTransaction(new Transaction(TransType.OUTGOING_TRANSFER, amount, acct1.getId()));
		acct1.setTransaction(transDAO.getTransActionsByAccountId(acct1.getId()));
		
		acct2 = acctDAO.updateAccount(acct2);
		transDAO.addTransaction(new Transaction(TransType.INCOMING_TRANSFER, amount, acct2.getId()));
		acct2.setTransaction(transDAO.getTransActionsByAccountId(acct2.getId()));
		
		return acct1;
		
	}
	
	//Check if a user exits
	public boolean checkIfUsernameExists(String username) {
		return custDAO.existsByUserName(username);
	}
	
}
