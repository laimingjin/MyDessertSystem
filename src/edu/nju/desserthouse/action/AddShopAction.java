package edu.nju.desserthouse.action;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.service.ShopService;
import edu.nju.desserthouse.model.Shop;

public class AddShopAction extends BaseAction {
	private String name;
	private String tel;
	
	
	@Autowired
	private ShopService shopService;
	public ShopService getShopService() {
		return shopService;
	}
	public void setShopService(ShopService shopService) {
		this.shopService = shopService;
	}
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTell() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
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
		if(request.getParameter("name")==""||request.getParameter("tel")==""){
			return input;
		}
		try{
			setName(request.getParameter("name"));
			setTel(request.getParameter("tel"));
			Shop shop=new Shop(name,tel);
			boolean result=shopService.addShop(shop);
			System.out.println(result);
			if(result){
//				ServletContext sc = request.getServletContext();
//				sc.setAttribute("name",name );
//				sc.setAttribute("tel",tel );
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
