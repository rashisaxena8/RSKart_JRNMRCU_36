package com.rskart.dao;
import java.util.*;
import com.rskart.model.*;

 public interface IProductDao {

	public boolean add(Product product);

	public boolean update(int productId);

	public boolean delete(int productId);

	public Product getProduct(int productId);

	public List<Product> getAllProduct();
}