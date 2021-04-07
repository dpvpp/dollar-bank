package com.dollarsbank.utility;

public class ConsolePrinterUtility {
	
	public static void welcomeScreen() {
		System.out.println(ColorsUtility.GREEN.COLOR + "+---------------------------------------------------+");
		System.out.println("|                                               " + ColorsUtility.YELLOW.COLOR  + "O" + ColorsUtility.GREEN.COLOR + "   |");
		System.out.println("|      Welcome to the Big Money Dollars Bank   " + ColorsUtility.YELLOW.COLOR  + "OOO" + ColorsUtility.GREEN.COLOR + "  |");
		System.out.println("|                                             " + ColorsUtility.YELLOW.COLOR  + "OOOOO" + ColorsUtility.GREEN.COLOR + " |");
		System.out.println("+---------------------------------------------------+");
		System.out.println(ColorsUtility.RED.COLOR + "WARNING: Big Money ballers only" + ColorsUtility.RESET.COLOR);
		System.out.println("1. Create new Account");
		System.out.println("2. Login");
		System.out.println("3. Exit");
		System.out.println("Select an option by typing 1, 2, or 3");
	}
	
	public static void printInvalidOption() {
		System.out.println(ColorsUtility.RED.COLOR + "+---------------------------------------------------------------+");
		System.out.println("| WARNING! The option you have selected is not valid, try again |");
		System.out.println("+---------------------------------------------------------------+" + ColorsUtility.RESET.COLOR);
	}
	
	public static void createAccountBanner() {
		System.out.println(ColorsUtility.BLUE.COLOR + "+---------------------------------------------------+");
		System.out.println("| Welcome! Enter the details for your account below |");
		System.out.println("+---------------------------------------------------+" + ColorsUtility.RESET.COLOR);
	}
	
	public static void printInvalidPhoneNumber() {
		System.out.println(ColorsUtility.RED.COLOR + "+--------------------------------------------------------------------------+");
		System.out.println("| WARNING! The phone number you have entered is not valid please try again |");
		System.out.println("+------------------------------------------------------------------------+" + ColorsUtility.RESET.COLOR);
	}
	
	public static void printInvalidAmount() {
		System.out.println(ColorsUtility.RED.COLOR + "+--------------------------------------+");
		System.out.println("| WARNING! Please enter a valid amount |");
		System.out.println("+------------------------------------+" + ColorsUtility.RESET.COLOR);
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
	
	public static void inputArrow() {
		System.out.print("> ");
	}
}
