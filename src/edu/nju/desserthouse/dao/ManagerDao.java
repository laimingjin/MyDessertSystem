package edu.nju.desserthouse.dao;

import java.util.List;
import edu.nju.desserthouse.model.Manager;

public interface ManagerDao {
	Manager save(Manager manager);
	
	void update(Manager manager);
	
	boolean findByAccountAndPassword(Manager manager);
	
	String getNameByAccount(int account);

	Manager getManagerByAccount(int account);
	
	List<Manager> getAllManagers();
	
}
