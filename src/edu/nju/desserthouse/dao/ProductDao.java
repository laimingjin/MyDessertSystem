package edu.nju.desserthouse.dao;

import java.util.List;
import edu.nju.desserthouse.model.Product;

public interface ProductDao {
	boolean save(Product product);
	
	boolean update(Product product);

	//Product getProduct(Product product);
	
	List<Product> getAllProduct();
	
	Product getProductByPid(int pid);
}