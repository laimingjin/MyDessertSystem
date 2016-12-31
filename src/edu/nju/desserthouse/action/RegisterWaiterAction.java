package edu.nju.desserthouse.action;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.service.MemberService;
import edu.nju.desserthouse.service.WaiterService;
import edu.nju.desserthouse.model.Member;
import edu.nju.desserthouse.model.Waiter;

public class RegisterWaiterAction extends BaseAction {
	private String name;
	private String level;
	private String password;
	private String shop;
	
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


	

	private String success = "success";
	private String input = "input";
	private String exist = "exist";

	

	

	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(request.getParameter("name")==""||request.getParameter("password")==""||request.getParameter("confirm")==""||request.getParameter("level")==""||request.getParameter("shop")==""){
			return input;
		}
		try{
			if(request.getParameter("password")!=null&&request.getParameter("password").equals(request.getParameter("confirm"))){
				setName(request.getParameter("name"));
				setPassword(request.getParameter("password"));
				setLevel(request.getParameter("Item"));
				setShop(request.getParameter("shop"));
			}else{
				return input;
			}
			
			Waiter waiter = new Waiter(name, password,level,shop);
			Waiter w = waiterService.registerWaiter(waiter);
			
			ServletContext sc = request.getServletContext();
			
			if(w != null){
				sc.setAttribute("accountType", "waiter");
				sc.setAttribute("account", Integer.toString(waiter.getAccount()));
				sc.setAttribute("account_name", name);
				sc.setAttribute("password",password );
				sc.setAttribute("level",level );
				sc.setAttribute("shop",shop );
				return success;
			}else{
				return exist;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return input;
	}

}
