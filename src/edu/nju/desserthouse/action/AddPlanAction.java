package edu.nju.desserthouse.action;

import java.text.SimpleDateFormat;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.Plan;
import edu.nju.desserthouse.model.Product;
import edu.nju.desserthouse.service.PlanService;
import edu.nju.desserthouse.service.ProductService;

public class AddPlanAction extends BaseAction{
	private String success = "success";
	private String input = "input";
	
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
		
		if(request.getParameter("shop")==""||request.getParameter("member.birth")==""||request.getParameter("product")==""||request.getParameter("price")==""||request.getParameter("quantity")==""){
			return input;
		}else{
			String temp=request.getParameter("product");
			
			String id=temp.substring(0, temp.indexOf(" "));
			Product product=productService.getProductByPid(Integer.parseInt(id));
			SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
			Plan plan=new Plan(Integer.parseInt(id), (String)request.getParameter("shop"), simpleDateFormat.parse((String)request.getParameter("member.birth").substring(0, 10)), Integer.parseInt(request.getParameter("quantity")), 0, Double.parseDouble(request.getParameter("price")),Integer.parseInt((String) sc.getAttribute("account")));
			planService.setPlan(plan);
			return success;
		}
	}
}
