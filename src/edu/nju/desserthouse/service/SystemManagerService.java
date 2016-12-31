package edu.nju.desserthouse.service;

import java.util.List;
import edu.nju.desserthouse.model.SystemManager;

public interface SystemManagerService {
	
	/**
	 * ������������
	 * @param member
	 * @return
	 */
	SystemManager registerSystemManager(SystemManager manager);
	
	/**
	 * ������������
	 * @param member
	 * @return
	 */
	boolean checkLogin(SystemManager manager);
	
	String getNameByAccount(int account);
	SystemManager getSystemManagerByAccount(int account);

}