package com.rskart.service;

import java.util.*;
import com.rskart.model.*;

public interface AdminOnProduct {

	boolean add(Product product);

	boolean update(int productId);

	boolean delete(int productId);

	Product getProduct(int productId);

	List<Product> getAllProduct();
}