package edu.nju.desserthouse.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.service.PlanService;
import edu.nju.desserthouse.model.Plan;
import edu.nju.desserthouse.model.Member;
import edu.nju.desserthouse.service.ProductService;
import edu.nju.desserthouse.service.MemberService;
import edu.nju.desserthouse.model.Product;

public class SeatAction extends BaseAction {
	private String success = "success";
	private String index = "index";
	private String login = "login";
	private String myaccount = "myaccount";
	private String nomoney = "nomoney";
	
	@Autowired
	private PlanService planService;
	private ProductService productService;
	private MemberService memberService;
	public PlanService getPlanService() {
		return planService;
	}

	public void setPlanService(PlanService planService) {
		this.planService = planService;
	}
	
	public ProductService getMovieService() {
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
		// TODO Auto-generated method stub
		ServletContext sc = request.getServletContext();
		
		int pid = Integer.parseInt(request.getParameter("planid"));
		System.out.println("pid:"+pid);
		Plan plan = planService.getPlanByPlanid(pid);
		Product movie = productService.getProductByPid(plan.getPlanid());
		String shop = plan.getShop();
		double price = plan.getPrice();
		
		int account = 0;
		
		String acccount_type = (String)sc.getAttribute("accountType");
		if(acccount_type == null){
			return login;
		}else if(acccount_type.equals("member")){
			account = Integer.parseInt((String)sc.getAttribute("account"));
			Member member = memberService.getMemberByAccount(account);
			double allcost = member.getAllcost();
			if(member.getMoney()<=50){
				return nomoney;
			}
			if(allcost<200){
				return myaccount;
			}else if(allcost>=200&&allcost<1000){
				price = (int) (price*0.9);
			}else if(allcost>=1000&&allcost<5000){
				price = (int) (price*0.8);
			}else if(allcost>=5000&&allcost<10000){
				price = (int) (price*0.7);
			}else if(allcost>=10000){
				price = (int) (price*0.6);
			}
		}else if(acccount_type.equals("waiter")){
			String act = request.getParameter("account");
			if(act!=""){
				account = Integer.parseInt(act);
				sc.setAttribute("member", act);
				Member member = memberService.getMemberByAccount(account);
				double allcost = member.getAllcost();
				if(member.getMoney()<=50){
					return nomoney;
				}
				if(allcost<200){
					return myaccount;
				}else if(allcost>=200&&allcost<1000){
					price = (int) (price*0.9);
				}else if(allcost>=1000&&allcost<5000){
					price = (int) (price*0.8);
				}else if(allcost>=5000&&allcost<10000){
					price = (int) (price*0.7);
				}else if(allcost>=10000){
					price = (int) (price*0.6);
				}
			}else{
				sc.setAttribute("member", null);
			}
		}
		
		
		
//		String[] sale = planService.getAllSale(pid);
//		String str = "";
//		for(int i = 0;i<sale.length;i++){
//			if(i == sale.length-1){
//				str = str+sale[i];
//			}else{
//				str = str+sale[i]+"/";
//			}
//		}
		
		String name = movie.getName();
		
		Date time = plan.getStarttime();
		
		System.out.println(shop);
		System.out.println(name);
		System.out.println(time);
	//	System.out.println(str);
		sc.setAttribute("price", price);
		sc.setAttribute("shop", shop);
		//sc.setAttribute("sale", str);
		sc.setAttribute("planid", Integer.toString(pid));
		sc.setAttribute("name", name);
		sc.setAttribute("time", time);
		
		return success;
	}

}
