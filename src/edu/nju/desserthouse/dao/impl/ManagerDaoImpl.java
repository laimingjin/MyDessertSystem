package edu.nju.desserthouse.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.dao.ManagerDao;
import edu.nju.desserthouse.model.Manager;
import edu.nju.desserthouse.dao.BaseDao;
import hibernate3.support.YeekuHibernateDaoSupport;

public class ManagerDaoImpl extends YeekuHibernateDaoSupport
implements ManagerDao {

	@Autowired
	private BaseDao baseDao;
	
	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	@Override
	public Manager save(Manager manager) {
		// TODO Auto-generated method stub
		Manager m=new Manager();
		baseDao.save(manager);
		System.out.println("save:name:"+manager.getName());
		return m;
	}

	@Override
	public void update(Manager manager) {
		// TODO Auto-generated method stub
		baseDao.update(manager);
	}

	@Override
	public boolean findByAccountAndPassword(Manager manager) {
		// TODO Auto-generated method stub
		Manager m=null;
		String hql = "from edu.nju.desserthouse.model.Manager where account ='"+manager.getAccount()+"'";
		Session session = baseDao.getNewSession();
		List<Manager> ml = session.createQuery(hql).list();
		if(ml.size()>0){
			m = ml.get(0);
			System.out.println(m.getPassword());
			if(m.getPassword().equals(manager.getPassword()))
				return true;
			else
				return false;
		}else{
			System.out.println("找不到");
			return false;
		}
		
		
	}

	@Override
	public String getNameByAccount(int account) {
		// TODO Auto-generated method stub
        Manager m = getManagerByAccount(account);
		
		if(m==null){
			return "";
		}else{
			System.out.println(m.getName());
			return m.getName();
		}
	}

	@Override
	public Manager getManagerByAccount(int account) {
		// TODO Auto-generated method stub
		Manager m=new Manager();
		String hql = "from edu.nju.desserthouse.model.Manager where account ='"+account+"'";
		Session session = baseDao.getNewSession();
		List<Manager> ml = session.createQuery(hql).list();
		if(ml.size()>0){
			m = ml.get(0);
		}else{
			System.out.println("找不到");
		}
		
		return m;
	}

	@Override
	public List<Manager> getAllManagers() {
		// TODO Auto-generated method stub
		String hql = "from edu.nju.desserthouse.model.Manager";
		Session session = baseDao.getNewSession();
		List<Manager> ml = session.createQuery(hql).list();
		return ml;
	}

}
