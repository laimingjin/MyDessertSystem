package edu.nju.desserthouse.service.impl;

import java.util.Random;

import edu.nju.desserthouse.dao.SystemManagerDao;
import edu.nju.desserthouse.model.Member;
import edu.nju.desserthouse.model.SystemManager;
import edu.nju.desserthouse.service.SystemManagerService;

public class SystemManagerServiceImpl implements SystemManagerService{
  private SystemManagerDao systemManagerDao;
  public void setSystemManagerDao(SystemManagerDao systemManagerDao){
	  this.systemManagerDao=systemManagerDao;
  }
	@Override
	public SystemManager registerSystemManager(SystemManager manager) {
		// TODO Auto-generated method stub
		SystemManager sm=systemManagerDao.save(manager);
		return sm;
		
	}

	@Override
	public boolean checkLogin(SystemManager manager) {
		// TODO Auto-generated method stub
		return systemManagerDao.findByAccountAndPassword(manager);
	}

	@Override
	public String getNameByAccount(int account) {
		// TODO Auto-generated method stub
		return systemManagerDao.getNameByAccount(account);
	}
	@Override
	public SystemManager getSystemManagerByAccount(int account) {
		// TODO Auto-generated method stub
		return systemManagerDao.getSystemManagerByAccount(account);
	}

}
