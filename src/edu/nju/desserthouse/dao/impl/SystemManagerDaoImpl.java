package edu.nju.desserthouse.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.dao.BaseDao;
import edu.nju.desserthouse.dao.SystemManagerDao;
import edu.nju.desserthouse.model.SystemManager;
import edu.nju.desserthouse.model.Waiter;
import hibernate3.support.YeekuHibernateDaoSupport;

public class SystemManagerDaoImpl  extends YeekuHibernateDaoSupport
implements SystemManagerDao{

	@Autowired
	private BaseDao baseDao;
	
	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	@Override
	public SystemManager save(SystemManager systemManager) {
		// TODO Auto-generated method stub
		SystemManager w = new SystemManager();
		// TODO Auto-generated method stub
		baseDao.save(systemManager);
		System.out.println("save:name:"+systemManager.getName());
		return w;
	}

	@Override
	public void update(SystemManager systemManager) {
		// TODO Auto-generated method stub
		 baseDao.update(systemManager);
	}

	@Override
	public boolean findByAccount(SystemManager systemManager) {
		// TODO Auto-generated method stub
//		@SuppressWarnings("unchecked")
		List<SystemManager> result = (List<SystemManager>)getHibernateTemplate().
				find("from systemManager as sm where "
				+"sm.account=?", systemManager.getAccount());
		if(result.size() != 0)
			return true;
		return false;
	}

	@Override
	public boolean findByAccountAndPassword(SystemManager systemManager) {
		// TODO Auto-generated method stub
		SystemManager w = (SystemManager) baseDao.load(SystemManager.class, systemManager.getAccount());
		
		if(w==null){
			return false;
		}
		
		System.out.println(w.getPassword());
		System.out.println(w.getName());
		if(w.getPassword().equals(systemManager.getPassword()))
			return true;
		else
			return false;
	}

	@Override
	public String getNameByAccount(int account) {
		// TODO Auto-generated method stub
		SystemManager w = (SystemManager) baseDao.load(SystemManager.class, account);
		if(w==null){
			return "";
		}
		return w.getName();
	}

	@Override
	public SystemManager getSystemManagerByAccount(int account) {
		// TODO Auto-generated method stub
		SystemManager w = (SystemManager) baseDao.load(SystemManager.class, account);
		
		return w;
	}

	@Override
	public List<SystemManager> getAllSystemManagers() {
		// TODO Auto-generated method stub
		String hql = "from edu.nju.desserthouse.model.SystemManager";
		Session session = baseDao.getNewSession();
		return session.createQuery(hql).list();
	}

}
