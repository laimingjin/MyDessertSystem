package edu.nju.desserthouse.action;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.Allsale;
import edu.nju.desserthouse.model.Plan;
import edu.nju.desserthouse.model.Shop;
import edu.nju.desserthouse.service.AllsaleService;
import edu.nju.desserthouse.service.MemberService;
import edu.nju.desserthouse.service.PlanService;
import edu.nju.desserthouse.service.ShopService;

public class Book_shopAction extends BaseAction{

	@Autowired
	private ShopService shopService;
	private AllsaleService allsaleService;
	private PlanService planService;
	public AllsaleService getAllsaleService() {
		return allsaleService;
	}

	public void setAllsaleService(AllsaleService allsaleService) {
		this.allsaleService = allsaleService;
	}
	public ShopService getShopService(){
		return shopService;
	}
	public void setShopService(ShopService shopService){
		this.shopService=shopService;
	}
	public PlanService getPlanService(){
		return planService;
	}
	 public void setPlanService(PlanService planService) {
		this.planService = planService;
	}
	@Override
	public String execute() throws Exception {
		ServletContext sc = request.getServletContext();
		
		
		
		List<Allsale>AllsaleList=allsaleService.getAllsales();
		List<Shop>shopList=shopService.getAllShops();
	    List<Plan>planList=planService.getAllPlan();
	    
	    String[] shopName=new String[shopList.size()];
	    String[][] planIDs=new String[planList.size()][100];
	    String[][] productIDs=new String[planList.size()][100];
	    int[][] quantity=new int[planList.size()][100];
	    int[]nums=new int[shopList.size()];
	    
	    for(int i=0;i<shopList.size();i++){
	    	Shop shop=shopList.get(i);
	    	shopName[i]=shop.getName();
	    	List<Plan>plans=planService.findPlanListByShop(shop.getName());
	    	for(int j=0;j<plans.size();j++){
	    		planIDs[i][j]=Integer.toString(plans.get(j).getPlanid());
	    		productIDs[i][j]=Integer.toString(plans.get(j).getPid());
	    		for(int k=0;k<AllsaleList.size();k++){
	    			Allsale allsale=AllsaleList.get(k);
	    			//System.out.println("sss"+allsale.getPlanIDs());
	    			String []con=allsale.getPlanIDs().split(";");
	    			System.out.println("sas"+con[0]);
	    			for(int m=0;m<con.length;m++){
	    				if(con[m].equals(plans.get(j).getPlanid()+"")){
	    					quantity[i][j]++;
	    					//System.out.println(quantity[i][j]);
	    				}
	    			}
	    		}
	    	}
	    	nums[i]=plans.size();
	    }
	    sc.setAttribute("planIDs",planIDs );
	    sc.setAttribute("productIDs",productIDs );
	    sc.setAttribute("quantity",quantity );
		sc.setAttribute("shopName",shopName );
		sc.setAttribute("nums", nums);
		sc.setAttribute("num", shopList.size());
	return "success";
	}
}
