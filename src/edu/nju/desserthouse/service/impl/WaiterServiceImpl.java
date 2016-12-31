package edu.nju.desserthouse.service.impl;

import java.util.Random;

import antlr.collections.List;
import edu.nju.desserthouse.dao.WaiterDao;
import edu.nju.desserthouse.model.Member;
import edu.nju.desserthouse.model.Waiter;
import edu.nju.desserthouse.service.WaiterService;

public class WaiterServiceImpl implements WaiterService{

	private WaiterDao waiterDao;
	public void setWaiterDao(WaiterDao waiterDao) {
		this.waiterDao = waiterDao;
	}
	
	@Override
	public Waiter registerWaiter(Waiter waiter) {
		// TODO Auto-generated method stub
		
		
			int account = 0;
			do{
				Random r = new Random(); 
				account = r.nextInt(9999999);
			}while(account>1000000&&waiterDao.getNameByAccount(account).equals(""));
			
			waiter.setAccount(account);
			Waiter w = waiterDao.save(waiter);
			return w;
		
	}

	@Override
	public boolean checkLogin(Waiter waiter) {
		// TODO Auto-generated method stub
		return waiterDao.findByAccountAndPassword(waiter);
	}

	@Override
	public String getNameByAccount(int account) {
		// TODO Auto-generated method stub
		return waiterDao.getNameByAccount(account);
	}

	@Override
	public java.util.List<Waiter> getAllWaiters() {
		// TODO Auto-generated method stub
		return waiterDao.getAllWaiters();
	}

	@Override
	public void deleteWaiter(Waiter waiter) {
		// TODO Auto-generated method stub
		 waiterDao.delete(waiter);;
	}

	@Override
	public Waiter getWaiterByAccount(int account) {
		// TODO Auto-generated method stub
		return waiterDao.getWaiterByAccount(account);
	}

	@Override
	public void updateWaiter(Waiter waiter) {
		// TODO Auto-generated method stub
		waiterDao.update(waiter);
	}

	@Override
	public java.util.List<Waiter> findWaiterListByShop(String shop) {
		// TODO Auto-generated method stub
		return waiterDao.findWaiterListByShop(shop);
	}
	
	
}
