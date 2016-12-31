package edu.nju.desserthouse.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.dao.BaseDao;
import edu.nju.desserthouse.dao.SaleDao;
import edu.nju.desserthouse.model.Sale;
import hibernate3.support.YeekuHibernateDaoSupport;

public class SaleDaoImpl extends YeekuHibernateDaoSupport
implements SaleDao{
	@Autowired
	private BaseDao baseDao;
	
	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	@Override
	public void save(Sale sale) {
		// TODO Auto-generated method stub
		baseDao.save(sale);
	}

}
