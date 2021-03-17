package com.rskart.dao;
import java.util.List;

import com.rskart.model.Product;

public interface ICartDao {

	public boolean add(Product prod, int customerId);

	public List<Product> viewCart(int id);

}