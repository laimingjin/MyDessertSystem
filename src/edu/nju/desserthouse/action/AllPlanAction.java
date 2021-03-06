package edu.nju.desserthouse.action;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.Plan;
import edu.nju.desserthouse.model.Product;
import edu.nju.desserthouse.model.Shop;
import edu.nju.desserthouse.service.PlanService;
import edu.nju.desserthouse.service.ProductService;
import edu.nju.desserthouse.service.ShopService;

public class AllPlanAction extends BaseAction{
	private String success = "success";
	private String index = "index";
	
	@Autowired
	private PlanService planService;
	private ProductService productService;
	public PlanService getPlanService() {
		return planService;
	}

	public void setPlanService(PlanService planService) {
		this.planService = planService;
	}
	
	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ServletContext sc = request.getServletContext();
		int account = Integer.parseInt((String)sc.getAttribute("account"));
//		String account_type = (String)sc.getAttribute("account_type");
//		if(account_type.equals("member")||account_type==null){
//			return index;
//		}
		
		
		
		List<Plan> pl = planService.getAllPlan();
		System.out.println("pl长度"+pl.size());
		
		String[] pid = new String[pl.size()];
		String[] product_name = new String[pl.size()];
		String[] starttime = new String[pl.size()];
		String[] shop = new String[pl.size()];
		String[] quantity = new String[pl.size()];
		String[] status = new String[pl.size()];
		String[] price = new String[pl.size()];
		String[] planid = new String[pl.size()];
		
		for(int j=0;j<pl.size();j++){
			if(  pl.get(j).getWid()!=account){
				pl.remove(j);
				j--;
			}
		}
		
		for(int i = 0;i<pl.size();i++){
			System.out.println(pl.size());
			Product p = productService.getProductByPid(pl.get(i).getPid());
			System.out.println(p.getName());
			pid[i]=Integer.toString(p.getPid());
			product_name[i] = p.getName();
			starttime[i] = pl.get(i).getStarttime().toString();
			shop[i] = (pl.get(i).getShop());
			quantity[i] = Integer.toString(pl.get(i).getQuantity());
			price[i] = Double.toString(pl.get(i).getPrice());
			status[i] = pickStatus(pl.get(i).getStatus());
			planid[i] = Integer.toString(pl.get(i).getPlanid());
		}
		sc.setAttribute("pid", pid);
		sc.setAttribute("product_name", product_name);
		sc.setAttribute("starttime", starttime);
		sc.setAttribute("shop", shop);
		sc.setAttribute("quantity", quantity);
		sc.setAttribute("price", price);
		sc.setAttribute("status", status);
		sc.setAttribute("planid", planid);
		sc.setAttribute("num", pl.size());
		
		return success;
	}
	String pickStatus(int status){
		if(status==0){
			return "待批准";
		}else if(status==1){
			return "已批准";
		}else if(status==-1){
			return "待修改";
		}else{
			return "未知";
		}
	}
}
