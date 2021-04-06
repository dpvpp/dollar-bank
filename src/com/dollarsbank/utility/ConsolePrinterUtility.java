package com.dollarsbank.utility;

public class ConsolePrinterUtility {
	
	public static void welcomeBanner() {
		System.out.println(ColorsUtility.GREEN.COLOR + "+-----------------------------------------+");
		System.out.println("|                                     " + ColorsUtility.YELLOW.COLOR  + "O" + ColorsUtility.GREEN.COLOR + "   |");
		System.out.println("|      Welcome to the Dollars Bank   " + ColorsUtility.YELLOW.COLOR  + "OOO" + ColorsUtility.GREEN.COLOR + "  |");
		System.out.println("|                                   " + ColorsUtility.YELLOW.COLOR  + "OOOOO" + ColorsUtility.GREEN.COLOR + " |");
		System.out.println("+-----------------------------------------+" + ColorsUtility.RESET.COLOR);
	}
	
}
