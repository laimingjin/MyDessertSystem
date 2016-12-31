package edu.nju.desserthouse.action;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.service.PlanService;
import edu.nju.desserthouse.model.Plan;
import edu.nju.desserthouse.model.PlanItem;
import edu.nju.desserthouse.service.ProductService;
import edu.nju.desserthouse.model.Product;

public class ListAction extends BaseAction {
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
		System.out.println(account);
		List<Plan> pl = planService.getAllPlan();
		System.out.println("size="+pl.size());
		for(int i = 0;i<pl.size();i++){
			if(pl.get(i).getStatus()!=1  || pl.get(i).getStarttime().compareTo(new Date())<0){
				pl.remove(i);
				i--;
			}
		}
		String[] planid = new String[pl.size()];
		String[] pid = new String[pl.size()];
		String[] product_name = new String[pl.size()];
		String[] branch = new String[pl.size()];
		String[] catagory = new String[pl.size()];
		String[] condition = new String[pl.size()];
		String[] content = new String[pl.size()];
		String[] price = new String[pl.size()];
		String[] quantity=new String[pl.size()];
		String[] starttime = new String[pl.size()];
		
		for(int i = 0;i<pl.size();i++){
			System.out.println(pl.size());
				Product p = productService.getProductByPid(pl.get(i).getPid());
				System.out.println(p.getName());
				planid[i]=Integer.toString(pl.get(i).getPlanid());
				pid[i] = Integer.toString(p.getPid());
				product_name[i] = p.getName();
				starttime[i] = pl.get(i).getStarttime().toString();
				catagory[i] = p.getCatagory();
				condition[i] = p.getKeepingcondition();
				content[i] = p.getContent();
				price[i] = Double.toString(pl.get(i).getPrice());
			    branch[i]=p.getBranch();
			    quantity[i]=Integer.toString(pl.get(i).getQuantity());
			
		}
		sc.setAttribute("planid", planid);
		sc.setAttribute("pid", pid);
		sc.setAttribute("product_name", product_name);
		sc.setAttribute("starttime", starttime);
		sc.setAttribute("catagory", catagory);
		sc.setAttribute("keepingcondition", condition);
		sc.setAttribute("content", content);
		sc.setAttribute("price", price);
		sc.setAttribute("branch", branch);
		sc.setAttribute("quantity", quantity);
		sc.setAttribute("num", pl.size());
		
		if(account>=1000000){
			return "member_success";
		}
		return "waiter_success";
	}
}
