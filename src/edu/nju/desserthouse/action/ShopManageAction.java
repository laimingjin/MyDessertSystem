package edu.nju.desserthouse.action;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.Shop;
import edu.nju.desserthouse.model.Waiter;
import edu.nju.desserthouse.service.ShopService;
import edu.nju.desserthouse.service.WaiterService;

public class ShopManageAction extends BaseAction{
	private String success = "success";
	private String index = "index";
	@Autowired
	private WaiterService waiterService;
	private ShopService shopService;
	public ShopService getShopService() {
		return shopService;
	}
	public void setShopService(ShopService shopService) {
		this.shopService = shopService;
	}
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
		System.out.println("ssssss");
		List<Shop>shopList=shopService.getAllShops();
		System.out.println("shopList.size="+shopList.size());
		
		String[] shop_name=new String[shopList.size()];
		String[] tel=new String[shopList.size()];
		int[] nums=new int[shopList.size()];
		String[][] account=new String[shopList.size()][100];
		String[][] name=new String[shopList.size()][100];
		String[][] password=new String[shopList.size()][100];
		String[][] shop=new String[shopList.size()][100];
		String[][] level=new String[shopList.size()][100];
		for(int i=0;i<shopList.size();i++){
			Shop s=shopList.get(i);
			shop_name[i]=s.getName();
			tel[i]=s.getTel();
			List<Waiter>waiterList=waiterService.findWaiterListByShop(s.getName());
			//System.out.println("waiterList.size="+waiterList.size());
			if(waiterList!=null){
				for(int j=0;j<waiterList.size();j++){
					Waiter w=waiterList.get(j);
					account[i][j]=Integer.toString(w.getAccount());
					name[i][j]=w.getName();
					password[i][j]=w.getPassword();
					shop[i][j]=w.getShop();
					level[i][j]=w.getLevel();
				}
				nums[i]=waiterList.size();
			}else{
				nums[i]=0;
			}
			
		}
		sc.setAttribute("shop_name", shop_name);
		sc.setAttribute("tel", tel);
		sc.setAttribute("num", shopList.size());
		sc.setAttribute("account",account);
		sc.setAttribute("name", name);
		sc.setAttribute("password",password );
		sc.setAttribute("level",level );
		sc.setAttribute("shop",shop );
		sc.setAttribute("nums", nums);
		return success;
	}
}
