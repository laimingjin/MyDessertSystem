package edu.nju.desserthouse.action;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.service.MemberService;
import edu.nju.desserthouse.service.WaiterService;
import edu.nju.desserthouse.model.Member;
import edu.nju.desserthouse.model.Waiter;

public class UpdateWaiterAction extends BaseAction {
	private String name;
	private String level;
	private String password;
	private String shop;
	private int account;
	@Autowired
	private WaiterService waiterService;
	public WaiterService getWaiterService() {
		return waiterService;
	}
	public void setWaiterService(WaiterService waiterService) {
		this.waiterService = waiterService;
	}
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLevel() {
		return level;
	}


	public void setLevel(String level) {
		this.level = level;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getShop() {
		return shop;
	}


	public void setShop(String shop) {
		this.shop = shop;
	}


	public String getSuccess() {
		return success;
	}


	public void setSuccess(String success) {
		this.success = success;
	}


	public String getInput() {
		return input;
	}


	public void setInput(String input) {
		this.input = input;
	}


	public String getExist() {
		return exist;
	}


	public void setExist(String exist) {
		this.exist = exist;
	}

	public int getAccount() {
		return account;
	}


	public void setAccount(int account) {
		this.account = account;
	}
	

	private String success = "success";
	private String input = "input";
	private String exist = "exist";

	

	

	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(request.getParameter("name")==""||request.getParameter("password")==""||request.getParameter("shop")==""||request.getParameter("level")==""){
			return input;
		}
		try{
			    setAccount(Integer.parseInt(request.getParameter("account")));
				setName(request.getParameter("name"));
				setPassword(request.getParameter("password"));
				//setLevel(request.getParameter("level"));
				setShop(request.getParameter("shop"));
			setLevel(request.getParameter("Item"));
			Waiter waiter = new Waiter(account,name, password,level,shop);
			waiterService.updateWaiter(waiter);
			//System.out.println("success");
			return success;
		}catch(Exception e){
			e.printStackTrace();
		}
		return input;
	}

}
