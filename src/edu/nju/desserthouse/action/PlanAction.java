package edu.nju.desserthouse.action;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.service.PlanService;
import edu.nju.desserthouse.model.Plan;
import edu.nju.desserthouse.service.ProductService;
import edu.nju.desserthouse.service.ShopService;
import edu.nju.desserthouse.model.Product;
import edu.nju.desserthouse.model.Shop;

public class PlanAction extends BaseAction {
	private String success = "success";
	private String index = "index";
	
	@Autowired
	private PlanService planService;
	private ProductService productService;
	private ShopService shopService;
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
	public ShopService getShopService(){
		return shopService;
	}
	public void setShopService(ShopService shopService){
		this.shopService=shopService;
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
		
		
		List<Product>allProducts=productService.getAllProduct();
		String[] all_product_name=new String[allProducts.size()];
		String[] all_product_id=new String[allProducts.size()];
		for(int j=0;j<allProducts.size();j++){
			all_product_id[j]=Integer.toString(allProducts.get(j).getPid());
			all_product_name[j]=allProducts.get(j).getName();
		}
		sc.setAttribute("all_product_pid", all_product_id);
		sc.setAttribute("all_product_name", all_product_name);
		sc.setAttribute("all_product_size", allProducts.size());
		
		List<Shop>allShops=shopService.getAllShops();
		String[] all_shop_name=new String[allShops.size()];
		for(int k=0;k<allShops.size();k++){
			all_shop_name[k]=allShops.get(k).getName();
		}
		sc.setAttribute("all_shop_name", all_shop_name);
		sc.setAttribute("all_shop_size", allShops.size());
		
		List<Plan> pl = planService.getAllPlan();
		for(int i = 0;i<pl.size();i++){
			if(pl.get(i).getStatus()==1 || pl.get(i).getWid()!=account){
				pl.remove(i);
				i--;
			}
		}
		System.out.println("pl长度"+pl.size());
		
		String[] pid = new String[pl.size()];
		String[] product_name = new String[pl.size()];
		String[] starttime = new String[pl.size()];
		String[] shop = new String[pl.size()];
		String[] quantity = new String[pl.size()];
		String[] status = new String[pl.size()];
		String[] price = new String[pl.size()];
		String[] planid = new String[pl.size()];
		
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
