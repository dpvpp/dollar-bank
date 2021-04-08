package com.dollarsbank.dao;

import com.dollarsbank.model.Account;

public interface AccountDAO {
	
	public Account addAccount(Account account);
	
	public Account getAccountById(int id);
	public Account getAccountByUserName(String username);
	
	public Account updateAccount(Account account);
	
	public boolean deleteAccountById(int id);
	
}
