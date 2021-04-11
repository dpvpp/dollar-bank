package com.dollarsbank.utility;

import java.util.Scanner;

import com.dollarsbank.controller.DollarsBankController;
import com.dollarsbank.model.Customer;

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
		long initDeposit;
		
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
				ConsolePrinterUtility.printInvalidPassword();;
				String confirm = in.nextLine().trim();
				if(confirm.equalsIgnoreCase("N")) {
					return;
				}
			}
		}
		
		System.out.println("How much money would you like to initially deposit");
		ConsolePrinterUtility.inputArrow();
		while(!in.hasNextLong() || (initDeposit = in.nextLong()) < 0) {
			ConsolePrinterUtility.printInvalidAmount();
			in.nextLine();
			ConsolePrinterUtility.inputArrow();
		}
		Customer customer = controller.createCustomer(firstName, lastName, phoneNumber, userId, password, initDeposit);
		customerMenu(customer, in);
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
						break;
					case 2 :
						break;
					case 3 :
						break;
					case 4 :
						break;
					case 5 :
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
}
