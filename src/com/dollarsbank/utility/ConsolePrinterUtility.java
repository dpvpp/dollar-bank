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
		System.out.println("Select and option by typing 1, 2, or 3");
	}
	
}
