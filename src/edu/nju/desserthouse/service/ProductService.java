package edu.nju.desserthouse.service;

import java.util.List;

import edu.nju.desserthouse.model.Product;


public interface ProductService {
    Product getProductByPid(int pid);
	
	boolean setProduct(Product product);//添加
	
	boolean updateProduct(Product product);
	
	List<Product> getAllProduct();
}
