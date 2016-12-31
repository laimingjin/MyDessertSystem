package edu.nju.desserthouse.service;

import java.util.List;
import edu.nju.desserthouse.model.Manager;

public interface ManagerService {
	
	/**
	 * ������������
	 * @param member
	 * @return
	 */
	Manager registerManager(Manager manager);
	
	/**
	 * ������������
	 * @param member
	 * @return
	 */
	boolean checkLogin(Manager manager);
	
	String getNameByAccount(int account);
	

}