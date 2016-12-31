package edu.nju.desserthouse.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.Member;
import edu.nju.desserthouse.model.Plan;
import edu.nju.desserthouse.service.MemberService;
import edu.nju.desserthouse.service.PlanService;
import edu.nju.desserthouse.service.ProductService;

public class TotalPriceAction extends BaseAction{
	private String success = "success";
	private String index = "index";
	private String login = "login";
	private String myaccount = "myaccount";
	private String nomoney = "nomoney";
	
	@Autowired
	private MemberService memberService;
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
	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public String execute() throws Exception {
		ServletContext sc = request.getServletContext();
		int account = Integer.parseInt((String)sc.getAttribute("account"));
		String planIDs=""; 
		String productIDs="";
		 String productNames="";
		 String prices="";
		 String quantities="";
		
		String[] checkbox = request.getParameterValues("checkbox");   
		double totalPrice=0;
		String[]nums= request.getParameterValues("quantity");
		//判断复选框是否有选 
		if(checkbox!=null&&!"".equals(checkbox)){   
		for(int i=0;i<checkbox.length;i++){   
	    String[] con=checkbox[i].split(";");
		int planid = Integer.parseInt(con[0]);
		int index=Integer.parseInt(con[1]);
		double price=Double.parseDouble(con[2]);
		totalPrice+=price*Integer.parseInt(nums[index]);
		
		Plan p=planService.getPlanByPlanid(planid);
		planIDs=planIDs+p.getPlanid()+";";
		productIDs=productIDs+p.getPid()+";";
		productNames=productNames+productService.getProductByPid(p.getPid()).getName()+";";
		prices=prices+price+";";
		quantities=quantities+nums[index]+";";
		}
		
		System.out.println("planids:"+planIDs);
		System.out.println("pids:"+productIDs);
		
		double totalPrice_after=totalPrice;
		Member member = memberService.getMemberByAccount(account);
		double allcost = member.getAllcost();
		if(member.getMoney()<=30){
			return nomoney;
		}
		if(allcost<200){
			return myaccount;
		}else if(allcost>=200&&allcost<1000){
			totalPrice_after = (int) (totalPrice_after*0.9);
		}else if(allcost>=1000&&allcost<5000){
			totalPrice_after = (int) (totalPrice_after*0.8);
		}else if(allcost>=5000&&allcost<10000){
			totalPrice_after = (int) (totalPrice_after*0.7);
		}else if(allcost>=10000){
			totalPrice_after = (int) (totalPrice_after*0.6);
		}
		
		
		
		sc.setAttribute("totalPrice_original", totalPrice);
		sc.setAttribute("account", account);
		sc.setAttribute("planIDs", planIDs);
		sc.setAttribute("productIDs", productIDs);
		sc.setAttribute("productNames", productNames);
		sc.setAttribute("quantities", quantities);
		sc.setAttribute("prices", prices);
		double credit=member.getCredit();
		
		String[] paytype = request.getParameterValues("paytype"); 
		boolean paybycash=false;
		boolean paybycard=false;
		boolean paybycredit=false;
		if(paytype!=null&&!"".equals(paytype)){
			for(int j=0;j<paytype.length;j++){
				if(paytype[j].equals("paybycash")){
					paybycash=true;
				}else if(paytype[j].equals("paybycard")){
					paybycard=true;
				}else if(paytype[j].equals("paybycredit")){
					paybycredit=true;
				}
			}
		}
		if(paybycash){
			if(paybycredit){
				totalPrice_after=totalPrice_after-credit/100;
				sc.setAttribute("credit", credit/100);
				sc.setAttribute("totalPrice_after", totalPrice_after);
				return "cashAndCredit";
			}else{
				sc.setAttribute("totalPrice_after", totalPrice_after);
				return "cash";
			}
		}else if(paybycard){
			if(paybycredit){
				totalPrice_after=totalPrice_after-credit/100;
				sc.setAttribute("credit", credit/100);
				sc.setAttribute("totalPrice_after", totalPrice_after);
				return "cardAndCredit";
			}else{
				sc.setAttribute("totalPrice_after", totalPrice_after);
				return "card";
			}
		}
		
		}
		
		return "cash";
	}
}
