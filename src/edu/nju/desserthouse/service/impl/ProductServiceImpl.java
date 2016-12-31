package edu.nju.desserthouse.service.impl;

import java.util.List;


import edu.nju.desserthouse.dao.ProductDao;
import edu.nju.desserthouse.model.Product;
import edu.nju.desserthouse.service.ProductService;

public class ProductServiceImpl implements ProductService{
    
	private ProductDao productDao;
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	@Override
	public Product getProductByPid(int pid) {
		// TODO Auto-generated method stub
		//Product product=new Product(pid);
		
		return productDao.getProductByPid(pid);
	}

	@Override
	public boolean setProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.save(product);
	}

	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.update(product);
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return productDao.getAllProduct();
	}

}
