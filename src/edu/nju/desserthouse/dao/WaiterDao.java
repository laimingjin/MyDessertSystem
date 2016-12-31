package edu.nju.desserthouse.dao;

import java.util.List;
import edu.nju.desserthouse.model.Waiter;

public interface WaiterDao {
	Waiter save(Waiter waiter);
	
	void update(Waiter waiter);
	
	boolean findByAccount(Waiter waiter);
	
	boolean findByAccountAndPassword(Waiter waiter);
	
	String getNameByAccount(int account);

	Waiter getWaiterByAccount(int account);
	
	List<Waiter> getAllWaiters();
	void delete(Waiter waiter);
	List<Waiter> findWaiterListByShop(String shop);
}
