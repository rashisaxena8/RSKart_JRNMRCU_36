package com.rskart.service;

import java.util.List;

import com.rskart.model.Customer;
import com.rskart.model.Product;

public interface ICustomerOperation {

	boolean register(Customer customer);

	List<Product> view();

	boolean add(int productId, int customerId);

	List<Product> viewCart(int cartId);

}