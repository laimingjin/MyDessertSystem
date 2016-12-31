package edu.nju.desserthouse.action;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.service.MemberService;
import edu.nju.desserthouse.service.ShopService;
import edu.nju.desserthouse.service.WaiterService;
import edu.nju.desserthouse.model.Member;
import edu.nju.desserthouse.model.Shop;
import edu.nju.desserthouse.model.Waiter;

public class UpdateShopAction extends BaseAction {
	private String name;
	private String tel;
	
	@Autowired
	private ShopService shopService;
	public void  setShopService(ShopService shopService){
		this.shopService=shopService;
	}
	public ShopService getShopService(){
		return shopService;
	}
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTel() {
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


	private String success = "success";
	private String input = "input";
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(request.getParameter("tel")==""){
			return input;
		}
		try{
				setName(request.getParameter("shop_name"));
				setTel(request.getParameter("tel"));
				
			Shop shop = new Shop(name, tel);
			shopService.updateShop(shop);
			
			return success;
		}catch(Exception e){
			e.printStackTrace();
		}
		return input;
	}

}
