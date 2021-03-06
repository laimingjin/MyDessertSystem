package edu.nju.desserthouse.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.Allsale;
import edu.nju.desserthouse.model.Member;
import edu.nju.desserthouse.service.AllsaleService;
import edu.nju.desserthouse.service.MemberService;

public class PaybycashAction extends BaseAction{
	@Autowired
	private MemberService memberService;
	private AllsaleService allsaleService;
	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	public AllsaleService getAllsaleService() {
		return allsaleService;
	}

	public void setAllsaleService(AllsaleService allsaleService) {
		this.allsaleService = allsaleService;
	}
	
	@Override
	public String execute() throws Exception {
		ServletContext sc = request.getServletContext();
		int account =(int) sc.getAttribute("account");
		String planIDs=(String)sc.getAttribute("planIDs");
		String productIDs =(String) sc.getAttribute("productIDs");
	    String productNames =(String) sc.getAttribute("productNames");
	    String quantities =(String) sc.getAttribute("quantities");
	    String prices =(String) sc.getAttribute("prices");
	    System.out.println(sc.getAttribute("quantities"));
	    System.out.println(sc.getAttribute("totalPrice_after"));
	    double totalPrice=(double)sc.getAttribute("totalPrice_after");
	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String time = df.format(new Date());
		Allsale allsale=new Allsale(account, planIDs,productIDs, productNames, prices, quantities, totalPrice, time,0);
		allsaleService.addAllsale(allsale);
		
		Member member=memberService.getMemberByAccount(account);
		//member.setMoney(member.getMoney()-totalPrice);
		member.setCredit((int)(member.getCredit()+totalPrice));
		memberService.update(member);
		return "success";
		
	}
}
