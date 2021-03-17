package com.rskart.controller;
import java.util.*;

import com.rskart.service.*;
import com.rskart.util.*;
import com.rskart.model.*;
import java.text.*;

public class AdminController {

	private static AdminOnProduct productService = new IAdminOnProduct();
	MainController mc= new MainController();
	
	// admin choice operations
	public void operations() {
		Scanner scanner = InputUtil.getScanner();
		boolean status = true;
		int id;
		System.out.println("Enter admin username:");
		String userName =scanner.next();
		System.out.println("Enter admin password:");
		String password=scanner.next();

		if (Admin.getUserName().equals(userName) && Admin.getPassword().equals(password)) {
			
			System.out.println("\n -------* Welcome Admin *-------");
			

			while (status) {
				System.out.println("\n 1. Enter product \n 2. Remove product \n 3. View Product \n 4. All Products \n 5. Exit");

				System.out.println("enter your choice:");
				int choice = scanner.nextInt();

				switch (choice) {

				case 1:
					Product product = readProductInfo();
					if (productService.add(product)) {
						System.out.println("Product added with " + product.getId() + " successfully.!");
					} else {
						System.out.println("Product not added.!");
					}
					break;


				case 2:
					System.out.println("Enter employee id: ");
					id = scanner.nextInt();
					if (productService.delete(id) == true)
						System.out.println("Product is sucessfully deleted: ");
					else
						System.out.println("Product does not exist");
					break;

				case 3:
					System.out.println("Enter Product id: ");
					id = scanner.nextInt();
					if (productService.getProduct(id) == null) {
						System.out.println("Product does not exist: ");
					} else {
						Product obj1 = new Product();
						obj1 = productService.getProduct(id);
						System.out.println(" " + obj1.toString());
					}
					break;
				case 4:
					List<Product> list = productService.getAllProduct();
					Product obj2=new Product();
					if (productService.getAllProduct() != null) {
						for (int i = 0; i < list.size(); i++) {
							obj2=list.get(i);
							System.out.println(obj2.toString());
						}
					} else
						System.out.println("No Product in the list, add some Products first");
					break;
				case 5:
					mc.runApplication();
					//System.exit(0);
				default:
					System.out.println("Enter a valid choice");


				}

			}
		} else {
			System.out.println("Wrong credentials");
		}
	}


	private Product readProductInfo() {

		Scanner scanner = InputUtil.getScanner();
		System.out.println(
				"Enter Product id, name, price, qty, Manufacturing Date (dd-MM-yyyy), Expiry Date (dd-MM-yyyy): ");
		int id = scanner.nextInt();
		String name = scanner.next();
		int price = scanner.nextInt();
		int quantity = scanner.nextInt();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String date1 = scanner.next();
		String date2 = scanner.next();

		// date format exception handling
		try {
			Date mfd = dateFormat.parse(date1);
			Date expiry = dateFormat.parse(date2);
			return new Product(id, name, price, quantity,mfd,expiry);
		} catch (Exception dateException) {
			System.out.println(dateException);
		}

		return new Product(id, name, price, quantity);
	}
}