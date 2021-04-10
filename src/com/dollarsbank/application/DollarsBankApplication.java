package com.dollarsbank.application;

import java.util.Scanner;

import com.dollarsbank.controller.DollarsBankController;
import com.dollarsbank.utility.ColorsUtility;
import com.dollarsbank.utility.ConsolePrinterUtility;

public class DollarsBankApplication {
	
	private static DollarsBankController controller = new DollarsBankController();
	
	public static void main(String[] args) {
		
		System.out.println(ColorsUtility.BLUE.COLOR + "I'm blue da ba dee dabba da-ee" + ColorsUtility.RESET.COLOR);
		mainMenu();
	}
	
	private static void mainMenu() {
		Scanner in = new Scanner(System.in);
		boolean exit = false;
		while(!exit) {
			
			ConsolePrinterUtility.welcomeScreen();
			
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
		ConsolePrinterUtility.createAccountBanner();
		String firstName;
		String lastName;
		String phoneNumber = null;
		String userId;
		String password;
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
			}
		}
		
		System.out.println("Please create a username");
		ConsolePrinterUtility.inputArrow();
		userId = in.nextLine();
		
		System.out.println("Please create a password, must be at least 8 characters with at least 1 letter, 1 number and 1 special character");
		ConsolePrinterUtility.inputArrow();
		password = in.nextLine();
		
		System.out.println("How much money would you like to initially deposit");
		ConsolePrinterUtility.inputArrow();
		while(!in.hasNextLong()) {
			ConsolePrinterUtility.printInvalidAmount();
			in.nextLine();
			ConsolePrinterUtility.inputArrow();
		}
		initDeposit = in.nextLong();
		controller.createCustomer(firstName, lastName, phoneNumber, userId, password, initDeposit);
		
	}
	
	private static void login(Scanner in) {
		ConsolePrinterUtility.loginBanner();
		String userId;
		String password;
		
		System.out.println("Please enter your username");
		ConsolePrinterUtility.inputArrow();
		userId = in.nextLine();
		
		System.out.println("Please enter your password");
		ConsolePrinterUtility.inputArrow();
		password = in.nextLine();
		
		System.out.println(userId + password);
	}
}
