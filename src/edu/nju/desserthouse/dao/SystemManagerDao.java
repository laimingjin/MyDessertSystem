package edu.nju.desserthouse.dao;

import java.util.List;
import edu.nju.desserthouse.model.SystemManager;

public interface SystemManagerDao {
	SystemManager save(SystemManager systemManager);
	
	void update(SystemManager systemManager);
	
	boolean findByAccount(SystemManager systemManager);
	
	boolean findByAccountAndPassword(SystemManager systemManager);
	
	String getNameByAccount(int account);

	SystemManager getSystemManagerByAccount(int account);
	
	List<SystemManager> getAllSystemManagers();
	
}
