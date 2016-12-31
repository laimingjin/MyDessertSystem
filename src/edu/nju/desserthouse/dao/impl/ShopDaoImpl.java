package edu.nju.desserthouse.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.dao.BaseDao;
import edu.nju.desserthouse.dao.ShopDao;
import edu.nju.desserthouse.model.Member;
import edu.nju.desserthouse.model.Shop;
import hibernate3.support.YeekuHibernateDaoSupport;

public class ShopDaoImpl extends YeekuHibernateDaoSupport
implements ShopDao{
	@Autowired
	private BaseDao baseDao;
	
	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	@Override
	public List<Shop> getAllShops() {
		// TODO Auto-generated method stub
		String hql = "from edu.nju.desserthouse.model.Shop";
		Session session = baseDao.getNewSession();
		return session.createQuery(hql).list();
	}

	@Override
	public void save(Shop shop) {
		// TODO Auto-generated method stub
		 baseDao.save(shop);
	}

	@Override
	public Shop findByName(String name) {
		// TODO Auto-generated method stub
		List<Shop> result = getAllShops();
		if(result.size() != 0){
			for(int i=0;i<result.size();i++){
				if(result.get(i).getName().equals(name)){
					return result.get(i);
				}
			}
		}
		return null;
	}

	@Override
	public void delete(Shop shop) {
		// TODO Auto-generated method stub
		baseDao.delete(shop);
	}

	@Override
	public void update(Shop shop) {
		// TODO Auto-generated method stub
		baseDao.update(shop);
	}

}
