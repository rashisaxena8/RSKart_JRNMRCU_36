package com.rskart.dao;

import java.util.*;


import com.rskart.model.*;
import com.rskart.util.*;


public class ProductDao implements IProductDao {

	private static Map<Long, Product> products;
	private static long origin = 1200L;

	static {
		products = new HashMap<Long, Product>();
	}
	
	//admin function to add product details
	@Override
	public boolean add(Product product) {

		int initialSize = products.size();

		products.put(origin++, product);

		if (products.size() > initialSize)
			return true;
		else
			return false;

	}
	
	//admin function to update product details
	@Override
	public boolean update(int productId) {
		for(Map.Entry<Long, Product> entry: products.entrySet())
		{
			Product obj=new Product();
			obj=entry.getValue();
			if(obj.getId()==productId)
			{
				Scanner scanner = InputUtil.getScanner();
				System.out.println("Enter Product id, name, price, qty: ");
				int id = scanner.nextInt();
				String name = scanner.next();
				int price = scanner.nextInt();
				int quantity = scanner.nextInt();
				Product prod=new Product(id, name, price, quantity);
				products.replace(entry.getKey(), prod);
				return true;
			}
		}

		return false;
	}
	//admin function to delete products
	@Override
	public boolean delete(int productId) {
		for(Map.Entry<Long, Product> entry:products.entrySet())
		{
			Product obj=new Product();
			obj=entry.getValue();
			if(obj.getId()==productId)
			{
				products.remove(entry.getKey());
				return true;
			}
		}
		return false;
	}

	//admin function to view a particular product details
	@Override
	public Product getProduct(int productId) {
		for(Map.Entry<Long, Product> entry:products.entrySet())
		{
			Product obj=new Product();
			obj=entry.getValue();
			if(obj.getId()==productId)
			{
				return obj;
			}
		}
		return new Product();
	}

	//admin function to view all the products 
	@Override
	public List<Product> getAllProduct() {
		ArrayList<Product> list=new ArrayList<Product>();

		Collection<Product> productlist=products.values();
		for(Product p:productlist)
		{
			list.add(p);

		}	
		return list;
	}
}