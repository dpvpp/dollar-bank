package com.dollarsbank.application;

import com.dollarsbank.utility.AppComponents;
import com.dollarsbank.utility.ColorsUtility;

public class DollarsBankApplication {
	
	public static void main(String[] args) {
		
		//Initial test to see colors in the console
		System.out.println(ColorsUtility.BLUE.COLOR + "I'm blue da ba dee dabba da-ee" + ColorsUtility.RESET.COLOR);
		//Launches main menu
		AppComponents.mainMenu();
		
	}
	
}
