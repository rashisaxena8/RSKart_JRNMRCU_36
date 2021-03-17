package com.rskart.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainController {


	public static void main(String[] args) {

		runApplication();

	}
	//begin the application
	public static void runApplication() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		AdminController adminController = new AdminController();
		CustomerController customerController = new CustomerController();
		Boolean action = true;
		Scanner scan = new Scanner(System.in);

		while (action) {

			System.out.println("---------------------------------");
			System.out.println("|     * Welcome to RSKart *    |");
			System.out.println("---------------------------------");
			System.out.println("---- Select User ----");
			System.out.println("\n 1.Admin \n 2.Customer \n 3.Exit");

			try {
				char ch = br.readLine().charAt(0);
				switch (ch) {
				case '1':
					adminController.operations();
					break;
				case '2':
					customerController.operations();
					break;
				case '3':
					System.out.println("------- * EXIT * -------");
					System.out.println("Exiting From The System \nThankyou.");
					action = false;
					break;
				default:
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}


		}


	}

}



/*
/
/
System.out.println("***Enetr Admin name*****");

String adm= scan.next();
System.out.println("***Enetr Admin password*****");
String pass= scan.next();

if(adm.equals("Rashi")&& pass.equals("123")) {}else {
	System.out.println("Invalid credentials");
}*/