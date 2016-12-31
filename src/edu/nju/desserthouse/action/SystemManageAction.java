package edu.nju.desserthouse.action;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.Waiter;
import edu.nju.desserthouse.service.WaiterService;

public class SystemManageAction extends BaseAction{

	
	private String success = "success";
	private String index = "index";
	
	@Autowired
	private WaiterService waiterService;
	public WaiterService getWaiterService() {
		return waiterService;
	}

	public void setWaiterService(WaiterService waiterService) {
		this.waiterService = waiterService;
	}
	
	
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ServletContext sc = request.getServletContext();
		
		List<Waiter> pl = waiterService.getAllWaiters();
		System.out.println("size="+pl.size());
		
		
		String[] account = new String[pl.size()];
		String[] name = new String[pl.size()];
		String[] password = new String[pl.size()];
		String[] level = new String[pl.size()];
		String[] shop=new String[pl.size()];
		for(int i = 0;i<pl.size();i++){
			//System.out.println(pl.size());
			Waiter waiter=pl.get(i);
				account[i] = Integer.toString(waiter.getAccount());
				name[i] = waiter.getName();
				password[i] = waiter.getPassword();
				level[i] = waiter.getLevel();
			    shop[i]=waiter.getShop();
		}
		
		sc.setAttribute("waiter_account", account);
		sc.setAttribute("name", name);
		sc.setAttribute("password", password);
		sc.setAttribute("level", level);
		sc.setAttribute("shop", shop);
		sc.setAttribute("num", pl.size());
		sc.setAttribute("index", 0);
		return success;
	}
}
