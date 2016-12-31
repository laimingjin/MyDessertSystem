package edu.nju.desserthouse.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.dao.BaseDao;
import edu.nju.desserthouse.dao.ProductDao;
import edu.nju.desserthouse.model.Product;
import hibernate3.support.YeekuHibernateDaoSupport;

public class ProductDaoImpl extends YeekuHibernateDaoSupport
implements ProductDao{

	@Autowired
	private BaseDao baseDao;
	
	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	
	@Override
	public boolean save(Product product) {
		// TODO Auto-generated method stub
		baseDao.save(product);
		return true;
	}

	@Override
	public boolean update(Product product) {
		// TODO Auto-generated method stub
		baseDao.update(product);
		Product p = getProductByPid(product.getPid());
		return p.getClass().equals(product);
	}

	

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		String hql = "from edu.nju.desserthouse.model.Product";
		Session session = baseDao.getNewSession();
		return session.createQuery(hql).list();
	}

	@Override
	public Product getProductByPid(int pid) {
		// TODO Auto-generated method stub
		return (Product) baseDao.load(Product.class, pid);
	}

}
