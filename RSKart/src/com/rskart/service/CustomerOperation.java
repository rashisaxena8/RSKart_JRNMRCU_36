package com.rskart.service;

import java.util.List;

import com.rskart.dao.*;
import com.rskart.model.*;

public class CustomerOperation implements ICustomerOperation {

	CustomerDao customerDao = new CustomerDao();
	CartDao cartDao = new CartDao();
	ProductDao productDao = new ProductDao();

	@Override
	public boolean register(Customer customer) {
		return customerDao.register(customer);
	}

	@Override
	public List<Product> view() {
		List<Product> allProducts;
		allProducts = productDao.getAllProduct();
		return allProducts;

	}

	@Override
	public boolean add(int productId, int customerId) {

		Product prod = productDao.getProduct(productId);
		return cartDao.add(prod, customerId);
	}

	@Override
	public List<Product> viewCart(int cartId) {

		return cartDao.viewCart(cartId);
	}

}