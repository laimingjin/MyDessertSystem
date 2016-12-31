package edu.nju.desserthouse.action;


import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.service.SystemManagerService;
import edu.nju.desserthouse.model.SystemManager;

public class SystemManageAccountAction extends BaseAction {
	private SystemManager systemManager;
	
	@Autowired
	private SystemManagerService systemManagerService;
	public SystemManagerService getSystemManagerService() {
		return systemManagerService;
	}

	private String success = "success";

	public void setSystemManagerService(SystemManagerService systemManagerService) {
		this.systemManagerService = systemManagerService;
	}

	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ServletContext sc = request.getServletContext();
		//System.out.println(sc.getAttribute("account"));
		//System.out.println(systemManager.getName());
		//System.out.println(systemManager.getPassword());
		int account = Integer.parseInt((java.lang.String) sc.getAttribute("account"));
		//String[]accounts=(String[])sc.getAttribute("account");
		//System.out.println(accounts[0]);
		setSystemManager(systemManagerService.getSystemManagerByAccount(account));
		
		sc.setAttribute("account_name",systemManager.getName());//个人信息界面
		sc.setAttribute("password", systemManager.getPassword());
//		sc.setAttribute("level", systemManager.getSmid());
	
		return success;
	}

	public SystemManager getSystemManager() {
		return systemManager;
	}

	public void setSystemManager(SystemManager systemManager) {
		this.systemManager = systemManager;
	}

}
