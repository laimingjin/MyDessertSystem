package edu.nju.desserthouse.service;

import java.util.List;
import edu.nju.desserthouse.model.Waiter;

public interface WaiterService {
	
	/**
	 * ������������
	 * @param member
	 * @return
	 */
	Waiter registerWaiter(Waiter waiter);
	
	/**
	 * ������������
	 * @param member
	 * @return
	 */
	boolean checkLogin(Waiter waiter);
	
	String getNameByAccount(int account);
	 public List<Waiter> getAllWaiters();
	 public void deleteWaiter(Waiter waiter);
	 public Waiter getWaiterByAccount(int account);
	 public void updateWaiter(Waiter waiter);
	 public List<Waiter> findWaiterListByShop(String shop);
}
