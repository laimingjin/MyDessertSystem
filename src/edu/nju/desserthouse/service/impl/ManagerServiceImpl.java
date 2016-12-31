package edu.nju.desserthouse.service.impl;

import edu.nju.desserthouse.model.Manager;
import edu.nju.desserthouse.service.ManagerService;
import edu.nju.desserthouse.dao.ManagerDao;

public class ManagerServiceImpl implements ManagerService{

    private ManagerDao managerDao;
	
	public void setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}
	@Override
	public Manager registerManager(Manager manager) {
		// TODO Auto-generated method stub
		Manager m = managerDao.save(manager);
		return m;
	}

	@Override
	public boolean checkLogin(Manager manager) {
		// TODO Auto-generated method stub
		return managerDao.findByAccountAndPassword(manager);
	}

	@Override
	public String getNameByAccount(int account) {
		// TODO Auto-generated method stub
		return managerDao.getNameByAccount(account);
	}

}
