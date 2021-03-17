package com.rskart.controller;

import com.rskart.service.*;
import java.util.*;
import com.rskart.model.*;
import com.rskart.util.*;



public class CustomerController {
	private static ICustomerOperation customerService = new CustomerOperation();

	//customer operation choices
	public void operations() {
		Scanner scanner = InputUtil.getScanner();
		boolean status = true;
		int id;

		while (status) {
			System.out.println("Welcome to Customer Operations");
			System.out.println(
					" 1. Register \n 2. View Products \n 3. Add product to cart \n 4. View cart \n 5. Exit");

			System.out.println("Enter your choice:");
			int choice = scanner.nextInt();

			switch (choice) {

			case 1:
				Customer customer = readCustomerInfo();
				if (customerService.register(customer)) {
					System.out.println("Customer with customer ID: " + customer.getId() + " added successfully!");
				} else {
					System.out.println("Customer not added.!");
				}
				break;

			case 2:
				System.out.println("The following are the products");
				List<Product> list = customerService.view();
				Product obj2 = new Product();
				if (customerService.view() != null) {
					for (int i = 0; i < list.size(); i++) {
						obj2 = list.get(i);
						System.out.println(obj2.toString());
					}
				} else
					System.out.println("No product available");
				break;

			case 3:
				System.out.println("Enter Product Id to be entered in the cart: ");
				id = scanner.nextInt();
				System.out.println("Enter Customer Id: ");
				int custId = scanner.nextInt();

				if (customerService.add(id, custId) == true)
					System.out.println("Product is sucessfully Added: ");
				else
					System.out.println("Product does not exist");
				break;

			case 4:
				System.out.println("Enter Customer Id");

				id = scanner.nextInt();
				if (customerService.viewCart(id) == null) {
					System.out.println("Cart is empty: ");
				} else {
					List<Product> cartList = new ArrayList<Product>();
					cartList = customerService.viewCart(id);
					for (int i = 0; i < cartList.size(); i++)
						System.out.println(" " + cartList.get(i));
				}
				break;
			case 5:
				status = false;
				System.out.println("Exiting Customer section....");
				break;
			default:
				System.out.println("Enter a valid choice");

			}

		}

	}

	private Customer readCustomerInfo() {

		Scanner scanner = InputUtil.getScanner();
		System.out.println("Enter id, name, email, phone, address");
		int id = scanner.nextInt();
		String name = scanner.next();
		String email = scanner.next();
		Long phone = scanner.nextLong();
		String address = scanner.next();

		Customer customer = new Customer(id, name, email, phone, address);
		return customer;
	}

}