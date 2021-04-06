package com.dollarsbank.application;

import java.util.Scanner;

import com.dollarsbank.utility.ColorsUtility;
import com.dollarsbank.utility.ConsolePrinterUtility;

public class DollarsBankApplication {
	
	public static void main(String[] args) {
		
		System.out.println(ColorsUtility.BLUE.COLOR + "I'm blue da ba dee dabba da-ee" + ColorsUtility.RESET.COLOR);
		mainMenu();
	}
	
	public static void mainMenu() {
		Scanner in = new Scanner(System.in);
		
		ConsolePrinterUtility.welcomeScreen();
		boolean exit = false;
		while(!exit) {
			
			ConsolePrinterUtility.inputArrow();;
			if(in.hasNextInt()) {
				int input = in.nextInt();
				switch(input) { 
					case 1 : 
						createAccount();
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
			}
			in.nextLine();
			
		}
		in.close();
	}
	
	public static void createAccount() {
		ConsolePrinterUtility.createAccountBanner();
	}
	
}
