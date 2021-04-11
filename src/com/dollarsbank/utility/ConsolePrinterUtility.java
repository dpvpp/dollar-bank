package com.dollarsbank.utility;

public class ConsolePrinterUtility {
	
	public static void welcomeScreen() {
		System.out.println(ColorsUtility.GREEN.COLOR + "+---------------------------------------------------+");
		System.out.println("|                                               " + ColorsUtility.YELLOW.COLOR  + "O" + ColorsUtility.GREEN.COLOR + "   |");
		System.out.println("|      Welcome to the Big Money Dollars Bank   " + ColorsUtility.YELLOW.COLOR  + "OOO" + ColorsUtility.GREEN.COLOR + "  |");
		System.out.println("|                                             " + ColorsUtility.YELLOW.COLOR  + "OOOOO" + ColorsUtility.GREEN.COLOR + " |");
		System.out.println("+---------------------------------------------------+");
		System.out.println(ColorsUtility.RED.COLOR + "WARNING: Big Money ballers only" + ColorsUtility.RESET.COLOR);
	}
	
	public static void mainOptions() {
		System.out.println("1. Create new Account");
		System.out.println("2. Login");
		System.out.println("3. Exit");
		System.out.println();
		System.out.println(ColorsUtility.GREEN.COLOR + "Select an option by typing 1, 2, or 3" + ColorsUtility.RESET.COLOR);
	}
	
	public static void printInvalidOption() {
		System.out.println(ColorsUtility.RED.COLOR + " WARNING! The option you have selected is not valid, try again" + ColorsUtility.RESET.COLOR);
	}
	
	public static void createAccountBanner() {
		System.out.println(ColorsUtility.BLUE.COLOR + "+---------------------------------------------------+");
		System.out.println("| Welcome! Enter the details for your account below |");
		System.out.println("+---------------------------------------------------+" + ColorsUtility.RESET.COLOR);
	}
	
	public static void printInvalidPhoneNumber() {
		System.out.println(ColorsUtility.RED.COLOR +  "WARNING! The phone number you have entered is not valid, try again? (Y/N)" + ColorsUtility.RESET.COLOR);
	}
	
	public static void printInvalidAmount() {
		System.out.println(ColorsUtility.RED.COLOR + "WARNING! Please enter a valid amount" + ColorsUtility.RESET.COLOR);
	}
	
	public static void loginBanner() {
		System.out.println(ColorsUtility.BLUE.COLOR + "+-------------------------------------------+");
		System.out.println("| Welcome! Please Enter login details below |");
		System.out.println("+-------------------------------------------+" + ColorsUtility.RESET.COLOR);
	}
	
	public static void exitScreen() {
		System.out.println(ColorsUtility.GREEN.COLOR + "+--------------------------------------------------------+");
		System.out.println("|                                                  " + ColorsUtility.YELLOW.COLOR  + "O" + ColorsUtility.GREEN.COLOR + "     |");
		System.out.println("|    Goodbye, if you make any big money while     " + ColorsUtility.YELLOW.COLOR  + "OOO" + ColorsUtility.GREEN.COLOR + "    |");
		System.out.println("|        you're gone please come back and        " + ColorsUtility.YELLOW.COLOR  + "OOOOO" + ColorsUtility.GREEN.COLOR + "   |");
		System.out.println("|               store it here       -------->   " + ColorsUtility.YELLOW.COLOR  + "OOOOOOO" + ColorsUtility.GREEN.COLOR + "  |");
		System.out.println("|                                              " + ColorsUtility.YELLOW.COLOR  + "OOOOOOOOO" + ColorsUtility.GREEN.COLOR + " |");
		System.out.println("+--------------------------------------------------------+" + ColorsUtility.RESET.COLOR);
	}
	
	public static void printSQLError() {
		System.out.println(ColorsUtility.RED.COLOR + "+--------------------------------------------------------+");
		System.out.println("| WARNING! There was an error connecting to the database |");
		System.out.println("+--------------------------------------------------------+" + ColorsUtility.RESET.COLOR);
	}
	
	public static void printUserExists() {
		System.out.println(ColorsUtility.RED.COLOR + "The username you have chose already exists, try again? (Y/N)" + ColorsUtility.RESET.COLOR);
	}
	
	public static void printInvalidPassword() {
		System.out.println(ColorsUtility.RED.COLOR + "The password you have entered is invalid, try again? (Y/N)" + ColorsUtility.RESET.COLOR);
	}
	
	public static void printInvalidLogin() {
		System.out.println(ColorsUtility.RED.COLOR + "Username or password is incorrect" + ColorsUtility.RESET.COLOR);
	}
	
	public static void customerWelcome() {
		System.out.println(ColorsUtility.BLUE.COLOR + "+------------------------------------------------------------+");
		System.out.println("| Welcome customer! Please Enter select an action from below |");
		System.out.println("+------------------------------------------------------------+" + ColorsUtility.RESET.COLOR);
	}
	
	public static void customerOptions() {
		System.out.println("1. Deposit");
		System.out.println("2. Withdraw");
		System.out.println("3. Transfer");
		System.out.println("4. View last 5 transactions");
		System.out.println("5. Display Customer Information");
		System.out.println("6. Sign out");
		System.out.println();
		System.out.println(ColorsUtility.GREEN.COLOR + "Select an option by typing 1, 2, 3, 4, 5 or 6" + ColorsUtility.RESET.COLOR);
	}
	
	public static void signOut() {
		System.out.println(ColorsUtility.GREEN.COLOR + "Signing out, please return soon and deposit more money" + ColorsUtility.RESET.COLOR);
	}
	
	public static void inputArrow() {
		System.out.print("> ");
	}
}
