package edu.nju.desserthouse.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.dao.AllsaleDao;
import edu.nju.desserthouse.dao.BaseDao;
import edu.nju.desserthouse.model.Allsale;
import edu.nju.desserthouse.model.Member;
import hibernate3.support.YeekuHibernateDaoSupport;

public class AllsaleDaoImpl extends YeekuHibernateDaoSupport implements AllsaleDao{

	@Autowired
	private BaseDao baseDao;
	
	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	@Override
	public boolean save(Allsale allsale) {
		// TODO Auto-generated method stub
		baseDao.save(allsale);
		return true;
	}

	@Override
	public List<Allsale> getAllsales() {
		// TODO Auto-generated method stub
		String hql = "from edu.nju.desserthouse.model.Allsale";
		Session session = baseDao.getNewSession();
		System.out.println(session.createQuery(hql).list().size());
		
		return session.createQuery(hql).list();
	}

	@Override
	public void delete(Allsale allsale) {
		// TODO Auto-generated method stub
		baseDao.delete(allsale);
	}

	@Override
	public Allsale findAllsaleByAid(int aid) {
		// TODO Auto-generated method stub
		List<Allsale>list=getAllsales();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getAid()==aid){
				return list.get(i);
			}
		}
		
		return null;
	}

}
