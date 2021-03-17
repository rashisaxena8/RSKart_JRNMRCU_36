package com.rskart.dao;

import java.util.HashMap;

import com.rskart.model.Customer;

public class CustomerDao implements ICustomerDao {
	ICartDao cartDao = new CartDao();
	private static HashMap<Integer, Customer> customerCart;
	private static int cartNo = 1;

	static {
		customerCart = new HashMap<Integer, Customer>();
	}

	@Override
	public boolean register(Customer customer) {

		int initialSize = customerCart.size();

		customerCart.put(cartNo, customer);

		if (customerCart.size() > initialSize)
			return true;
		else
			return false;
	}

}