package com.dollarsbank.application;

import com.dollarsbank.utility.ColorsUtility;
import com.dollarsbank.utility.ConsolePrinterUtility;

public class DollarsBankApplication {
	
	public static void main(String[] args) {
		
		System.out.println(ColorsUtility.BLUE.COLOR + "I'm blue da ba dee dabba da-ee" + ColorsUtility.RESET.COLOR);
		ConsolePrinterUtility.welcomeBanner();
	}
}
