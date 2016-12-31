package edu.nju.desserthouse.action;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.Shop;
import edu.nju.desserthouse.model.Waiter;
import edu.nju.desserthouse.service.ShopService;
import edu.nju.desserthouse.service.WaiterService;

public class DeleteShopAction extends BaseAction{
private Shop shop;
@Autowired
private ShopService shopService;
private WaiterService waiterService;
public void  setShopService(ShopService shopService){
	this.shopService=shopService;
}
public ShopService getShopService(){
	return shopService;
}
public WaiterService getWaiterService() {
	return waiterService;
}
public void setWaiterService(WaiterService waiterService) {
	this.waiterService = waiterService;
}

private String success="success";
private String existWaiter="existWaiter";
@Override
public String execute() throws Exception {
	ServletContext sc = request.getServletContext();
	String name=request.getParameter("shop_name");
	System.out.println(name);
	setShop(shopService.findShopByName(name));
	List<Waiter>waiterList=waiterService.findWaiterListByShop(shop.getName());
	if(waiterList.size()!=0){
		return existWaiter;
	}else{
	shopService.deleteShop(shop);
	return success;
	}
}
public void setShop(Shop shop){
	this.shop=shop;
}
public Shop getShopr(){
	return shop;
}
}
