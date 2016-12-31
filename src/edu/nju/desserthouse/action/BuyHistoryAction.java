package edu.nju.desserthouse.action;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import edu.nju.desserthouse.model.Allsale;
import edu.nju.desserthouse.model.Recharge;
import edu.nju.desserthouse.service.MemberService;

public class BuyHistoryAction extends BaseAction {
	@Autowired
	private MemberService memberService;
	public MemberService getMemberService() {
		return memberService;
	}

	private String success = "success";

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	
	
	
	@Override
	public String execute() throws Exception {
		ServletContext sc = request.getServletContext();
		System.out.println("account="+(String)request.getParameter("member_account"));
		int account = Integer.parseInt((String)request.getParameter("member_account"));
		
	List<Allsale> sl = memberService.getAllsaleByAccount(account);//我的消费缴费
	List<Recharge> rl = memberService.getRechargeByAccount(account);
	String[] money_cost = new String[sl.size()];
	String[] time_cost = new String[sl.size()];
	String[] money_recharge = new String[rl.size()];
	String[] time_recharge = new String[rl.size()];
	for(int i = 0;i<sl.size();i++){
		money_cost[i] = Double.toString(sl.get(i).getTotalPrice());
		time_cost[i] = sl.get(i).getDate().substring(0,16);
		System.out.println("sssss"+sl.get(i).getAid());
		System.out.println(money_cost[i]);
		System.out.println(time_cost[i]);
	}
	for(int i = 0;i<rl.size();i++){
		money_recharge[i] = Integer.toString(rl.get(i).getCost());
		time_recharge[i] = rl.get(i).getDate().substring(0,16);
	}
	sc.setAttribute("money_cost", money_cost);
	sc.setAttribute("time_cost", time_cost);
	sc.setAttribute("num_cost", sl.size());
	sc.setAttribute("money_recharge", money_recharge);
	sc.setAttribute("time_recharge", time_recharge);
	sc.setAttribute("num_recharge", time_recharge.length);
	return success;
}
}
