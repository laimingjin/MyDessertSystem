package edu.nju.desserthouse.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.Allsale;
import edu.nju.desserthouse.model.Plan;
import edu.nju.desserthouse.service.AllsaleService;
import edu.nju.desserthouse.service.PlanService;

public class ReturnListAction extends BaseAction{
	@Autowired
	private AllsaleService allsaleService;
	private PlanService planService;
	public AllsaleService getAllsaleService() {
		return allsaleService;
	}

	public void setAllsaleService(AllsaleService allsaleService) {
		this.allsaleService = allsaleService;
	}
	public PlanService getPlanService() {
		return planService;
	}

	public void setPlanService(PlanService planService) {
		this.planService = planService;
	}
	@Override
	public String execute() throws Exception {
		ServletContext sc = request.getServletContext();
		int account = Integer.parseInt((String)sc.getAttribute("account"));
		List<Allsale>AllsaleList=allsaleService.getAllsales();
		
		for(int n=0;n<AllsaleList.size();n++){
			if(AllsaleList.get(n).getMember_account()!=account  || AllsaleList.get(n).getWaiter_account()!=0){
				AllsaleList.remove(n);
				n--;
			}
		}
		
		for(int i=0;i<AllsaleList.size();i++){
			Allsale allsale=AllsaleList.get(i);
			String planIDs=allsale.getPlanIDs();
			String[]tem=planIDs.split(";");
			Plan p=planService.getPlanByPlanid(Integer.parseInt(tem[0]));
			SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if((new Date()).compareTo(p.getStarttime())>0){
				AllsaleList.remove(i);
				i--;
			}
		}
		
		 int[] aid=new int[AllsaleList.size()];
		 int[] member_account=new int[AllsaleList.size()];
		 String[] planIDs=new String[AllsaleList.size()];
		 String[] productIDs=new String[AllsaleList.size()];
		 String[] productNames=new String[AllsaleList.size()];
		 String[] prices=new String[AllsaleList.size()];
		 String[] quantities=new String[AllsaleList.size()];
		 double[] totalPrice=new double[AllsaleList.size()];
		 String[] date=new String[AllsaleList.size()];
		 int[] waiter_account=new int[AllsaleList.size()];
		 
		 for(int j=0;j<AllsaleList.size();j++){
			 Allsale allsale=AllsaleList.get(j);
			 aid[j]=allsale.getAid();
			 member_account[j]=allsale.getMember_account();
			 planIDs[j]=allsale.getPlanIDs();
			 productIDs[j]=allsale.getProductIDs();
			 productNames[j]=allsale.getProductNames();
			 prices[j]=allsale.getPrices();
			 quantities[j]=allsale.getQuantities();
			 totalPrice[j]=allsale.getTotalPrice();
			 date[j]=allsale.getDate();
			 waiter_account[j]=allsale.getWaiter_account();
		 }
		 
		 sc.setAttribute("aid", aid);
		 sc.setAttribute("member_account",member_account );
		 sc.setAttribute("planIDs",planIDs );
		 sc.setAttribute("productIDs", productIDs);
		 sc.setAttribute("productNames",productNames );
		 sc.setAttribute("prices",prices );
		 sc.setAttribute("quantities", quantities);
		 sc.setAttribute("totalPrice",totalPrice);
		 sc.setAttribute("date",date );
		 sc.setAttribute("waiter_account",waiter_account );
		 sc.setAttribute("num", AllsaleList.size());
		 
		 return "success";
	}
}
