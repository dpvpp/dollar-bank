package com.dollarsbank.utility;

import java.util.List;
import java.util.Scanner;

import com.dollarsbank.controller.DollarsBankController;
import com.dollarsbank.model.Account;
import com.dollarsbank.model.Customer;
import com.dollarsbank.model.Transaction;

public class AppComponents {
	
	private static DollarsBankController controller = new DollarsBankController();
	
	public static void mainMenu() {
		
		ConsolePrinterUtility.welcomeScreen();
		Scanner in = new Scanner(System.in);
		boolean exit = false;
		
		while(!exit) {
			
			System.out.println();
			
			ConsolePrinterUtility.mainOptions();
			
			ConsolePrinterUtility.inputArrow();
			if(in.hasNextInt()) {
				int input = in.nextInt();
				in.nextLine();
				switch(input) { 
					case 1 : 
						createAccount(in);
						break;
					case 2 :
						login(in);
						break;
					case 3 :
						ConsolePrinterUtility.exitScreen();
						exit = true;
						break;
					default :
						ConsolePrinterUtility.printInvalidOption();
						break;
				}
			} else {
				ConsolePrinterUtility.printInvalidOption();
				in.nextLine();
			}
			
		}
		in.close();
	}
	
	private static void createAccount(Scanner in) {
		
		System.out.println();
		ConsolePrinterUtility.createAccountBanner();
		String firstName;
		String lastName;
		String phoneNumber = null;
		String userId = null;
		String password = null;
		double initDeposit;
		
		System.out.println("Please enter your first name");
		ConsolePrinterUtility.inputArrow();
		firstName = in.nextLine();
		
		System.out.println("Please enter your last name");
		ConsolePrinterUtility.inputArrow();
		lastName = in.nextLine();
		
		System.out.println("Please enter your phone number");
		boolean valid = false;
		while(!valid) {
			ConsolePrinterUtility.inputArrow();
			phoneNumber = in.nextLine();
			if(phoneNumber.matches("\\(?\\d{3}\\)?[- ]?\\d{3}[- ]?\\d{4}")) {
				valid = true;
			} else {
				ConsolePrinterUtility.printInvalidPhoneNumber();
				ConsolePrinterUtility.inputArrow();
				String confirm = in.nextLine().trim();
				if(confirm.equalsIgnoreCase("N")) {
					return;
				}
			}
		}
		
		System.out.println("Please create a username");
		valid = false;
		while(!valid) {
			ConsolePrinterUtility.inputArrow();
			userId = in.nextLine();
			if(controller.checkIfUsernameExists(userId)) {
				ConsolePrinterUtility.printUserExists();
				ConsolePrinterUtility.inputArrow();
				String confirm = in.nextLine().trim();
				if(confirm.equalsIgnoreCase("N")) {
					return;
				}
			} else {
				valid = true;
			}
		}
		
		System.out.println("Please create a password, must be at least 8 characters with at least 1 letter, 1 number and 1 special character");
		valid = false;
		while(!valid) {
			ConsolePrinterUtility.inputArrow();
			password = in.nextLine();
			if(password.matches(".*[A-Za-z].*") && 
			   password.matches(".*[0-9].*") && 
			   password.matches(".*[^A-Za-z0-9].*") &&
			   password.length() >= 8) {
				valid = true;
			} else {
				ConsolePrinterUtility.printInvalidPassword();
				ConsolePrinterUtility.inputArrow();
				String confirm = in.nextLine().trim();
				if(confirm.equalsIgnoreCase("N")) {
					return;
				}
			}
		}
		
		System.out.println("How much money would you like to initially deposit");
		ConsolePrinterUtility.inputArrow();
		while(!in.hasNextDouble() || (initDeposit = in.nextDouble()) < 0) {
			in.nextLine();
			ConsolePrinterUtility.printInvalidAmount();
			ConsolePrinterUtility.inputArrow();
			String confirm = in.nextLine().trim();
			if(confirm.equalsIgnoreCase("N")) {
				return;
			}
			ConsolePrinterUtility.inputArrow();
		}
		Customer customer = controller.createCustomer(firstName, lastName, phoneNumber, userId, password, initDeposit);
		customerMenu(customer, in);
		ConsolePrinterUtility.success();
	}
	
	private static void login(Scanner in) {
		
		System.out.println();
		ConsolePrinterUtility.loginBanner();
		String userId;
		String password;
		
		System.out.println("Please enter your username");
		ConsolePrinterUtility.inputArrow();
		userId = in.nextLine();
		
		System.out.println("Please enter your password");
		ConsolePrinterUtility.inputArrow();
		password = in.nextLine();
		
		Customer customer = controller.getCustomer(userId, password);
		if(customer == null) {
			ConsolePrinterUtility.printInvalidLogin();
		} else {
			ConsolePrinterUtility.success();
			customerMenu(customer, in);
		}
	}
	
	private static void customerMenu(Customer customer, Scanner in) {
		
		System.out.println();
		ConsolePrinterUtility.customerWelcome();;
		boolean logout = false;
		
		while(!logout) {
			
			System.out.println();
			ConsolePrinterUtility.customerOptions();;
			
			ConsolePrinterUtility.inputArrow();
			if(in.hasNextInt()) {
				int input = in.nextInt();
				in.nextLine();
				switch(input) { 
					case 1 : 
						customer.setAccount(deposit(in, customer.getAccount()));
						break;
					case 2 :
						customer.setAccount(withdraw(in, customer.getAccount()));
						break;
					case 3 :
						customer.setAccount(transfer(in, customer.getAccount()));
						break;
					case 4 :
						viewTransactions(customer.getAccount());
						break;
					case 5 :
						viewDetails(customer);
						break;
					case 6 :
						logout = true;
						ConsolePrinterUtility.signOut();
						break;
					default :
						ConsolePrinterUtility.printInvalidOption();
						break;
				}
			} else {
				ConsolePrinterUtility.printInvalidOption();
				in.nextLine();
			}
			
		}
		
	}
	
	public static Account deposit(Scanner in, Account account) {
		
		double amount = 0;
		
		System.out.println();
		ConsolePrinterUtility.depositBanner();
		System.out.println();
		System.out.println("Please enter the amount you would like to deposit");
		System.out.println("Current balance: " + account.getBalance());
		ConsolePrinterUtility.inputArrow();
		while(!in.hasNextDouble() || (amount = in.nextDouble()) < 0) {
			in.nextLine();	
			ConsolePrinterUtility.printInvalidAmount();
			ConsolePrinterUtility.inputArrow();
			String confirm = in.nextLine().trim();
			if(confirm.equalsIgnoreCase("N")) {
				return account;
			}
			ConsolePrinterUtility.inputArrow();
		}
		
		account = controller.deposit(account, amount);

		ConsolePrinterUtility.success();
		return account;
	}
	
	public static Account withdraw(Scanner in, Account account) {
		
		double amount = 0;
		
		System.out.println();
		ConsolePrinterUtility.withdrawBanner();
		System.out.println();
		System.out.println("Please enter the amount you would like to withdraw");
		System.out.println("Current balance: " + account.getBalance());
		ConsolePrinterUtility.inputArrow();
		while(!in.hasNextDouble() || (amount = in.nextDouble()) < 0 || amount > account.getBalance()) {
			in.nextLine();	
			ConsolePrinterUtility.printInvalidWithdrawal();;
			ConsolePrinterUtility.inputArrow();
			String confirm = in.nextLine().trim();
			if(confirm.equalsIgnoreCase("N")) {
				return account;
			}
			ConsolePrinterUtility.inputArrow();
		}
		
		account = controller.withdraw(account, amount);

		ConsolePrinterUtility.success();
		return account;
	}
	
	public static Account transfer(Scanner in, Account account1) {
		
		double amount = 0;
		
		System.out.println();
		ConsolePrinterUtility.transferBanner();;
		System.out.println();
		System.out.println("Please enter username of the account you would like to transfer to");
		boolean valid = false;
		String userId = null;
		while(!valid) {
			ConsolePrinterUtility.inputArrow();
			userId = in.nextLine();
			if(!controller.checkIfUsernameExists(userId)) {
				ConsolePrinterUtility.printUserDoesntExists();
				ConsolePrinterUtility.inputArrow();
				String confirm = in.nextLine().trim();
				if(confirm.equalsIgnoreCase("N")) {
					return account1;
				}
			} else {
				valid = true;
			}
		}
		Account account2 = controller.getAccount(userId);
		
		System.out.println("Please enter the amount you would like to transfer");
		System.out.println("Current balance: " + account1.getBalance());
		ConsolePrinterUtility.inputArrow();
		while(!in.hasNextDouble() || (amount = in.nextDouble()) < 0 || amount > account1.getBalance()) {
			in.nextLine();	
			ConsolePrinterUtility.printInvalidWithdrawal();;
			ConsolePrinterUtility.inputArrow();
			String confirm = in.nextLine().trim();
			if(confirm.equalsIgnoreCase("N")) {
				return account1;
			}
			ConsolePrinterUtility.inputArrow();
		}
		
		account1 = controller.transfer(account1, account2, amount);

		ConsolePrinterUtility.success();
		return account1;
	}
	
	public static void viewTransactions(Account account) {
		
		System.out.println();
		ConsolePrinterUtility.transactionBanner();
		System.out.println();
		
		List<Transaction> transactions = account.getTransactions();
		for(int i = 1; i < 5 && transactions.size() - i >= 0; i++) {
			Transaction trans = transactions.get(transactions.size() - i);
			System.out.println(i + ". " + trans.getType().VALUE + ": " + " $" + trans.getAmount() + " \t\t\t" + trans.getDate());
		}
	}
	
	public static void viewDetails(Customer customer) {
		
		System.out.println();
		ConsolePrinterUtility.detailsBanner();
		System.out.println();
		
		System.out.println("First name: " + customer.getFirstName());
		System.out.println("Last name: " + customer.getLastName());
		System.out.println("Phone number: " + customer.getPhoneNumber());
		System.out.println("Username: " + customer.getUserId());
		System.out.println("Account balance: " + customer.getAccount().getBalance());
	}
}
