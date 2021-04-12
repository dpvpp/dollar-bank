package com.dollarsbank.dao;

import com.dollarsbank.model.Account;

//Account DAO interface
public interface AccountDAO {
	
	public Account addAccount(Account account);
	
	public Account getAccountById(int id);
	public Account getAccountByUserName(String username);
	
	public Account updateAccount(Account account);
	
	public boolean deleteAccountByUser(String username);
	
}
