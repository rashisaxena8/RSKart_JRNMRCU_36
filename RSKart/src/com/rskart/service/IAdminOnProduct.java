package com.rskart.service;
import java.util.*;
import com.rskart.dao.*;
import com.rskart.model.*;


public class IAdminOnProduct implements AdminOnProduct {

	private static ProductDao ProductDao = new ProductDao();

	@Override
	public boolean add(Product product) {
		return ProductDao.add(product);
	}

	@Override
	public boolean update(int id) {

		return ProductDao.update(id);
	}

	@Override
	public boolean delete(int productId) {
		return ProductDao.delete(productId);
	}

	@Override
	public Product getProduct(int productId) {
		return ProductDao.getProduct(productId);
	}

	

	@Override
	public List<Product> getAllProduct() {
		return ProductDao.getAllProduct();
	}

}