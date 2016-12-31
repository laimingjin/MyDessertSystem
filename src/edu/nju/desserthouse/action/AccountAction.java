package edu.nju.desserthouse.action;

import java.util.List;

import javax.servlet.ServletContext;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.service.MemberService;
import edu.nju.desserthouse.model.Allsale;
import edu.nju.desserthouse.model.Member;
import edu.nju.desserthouse.model.Recharge;

public class AccountAction extends BaseAction {
	private Member member;
	
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
		// TODO Auto-generated method stub
		ServletContext sc = request.getServletContext();
		int account = Integer.parseInt((String)sc.getAttribute("account"));
		setMember(memberService.getMemberByAccount(account));
		
		sc.setAttribute("name",member.getName());
		sc.setAttribute("password", member.getPassword());
		sc.setAttribute("age",Integer.toString(member.getAge()));
		sc.setAttribute("gender", member.getGender());
		sc.setAttribute("address", member.getAddress());
		sc.setAttribute("tel",Long.toString(member.getTel()));//个人信息界面
		sc.setAttribute("card", member.getCard());
		sc.setAttribute("credit", Integer.toString(member.getCredit()));
		sc.setAttribute("money", Double.toString(member.getMoney()));
		sc.setAttribute("allcost", Double.toString(member.getAllcost()));
		sc.setAttribute("level", Integer.toString(member.getLevel()));
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		sc.setAttribute("date", simpleDateFormat.format(member.getDate()));
		
		Date today=new Date();
		Date before=member.getDate();
		boolean result=overOneYear(before, today);
		System.out.println("result="+result);
		if(member.getStatus()==1 && result && (member.getMoney()<30)){
			member.setStatus(-1);
			member.setDate(today);
		}else if(member.getStatus()==-1  && result){
			member.setStatus(-2);
			member.setDate(today);
		}else if(member.getStatus()==-1 && member.getMoney()>30){
			member.setStatus(1);
			member.setDate(today);
		}
		memberService.update(member);
		
		switch(member.getLevel()){
		case 0:sc.setAttribute("level", "普卡");break;
		case 1:sc.setAttribute("level", "银卡");break;
		case 2:sc.setAttribute("level", "金卡");break;
		case 3:sc.setAttribute("level", "钻石卡");break;
		default:sc.setAttribute("level", "未知");
		}
		switch(member.getStatus()){
		case -2:sc.setAttribute("status", "停止使用");break;
		case -1:sc.setAttribute("status", "暂停使用");break;
		case 0:sc.setAttribute("status", "未激活");break;
		case 1:sc.setAttribute("status", "活跃");break;
		default:sc.setAttribute("status", "未知");
		}
		
		List<Allsale> sl = memberService.getAllsaleByAccount(account);//我的消费缴费
		List<Recharge> rl = memberService.getRechargeByAccount(account);
		String[] money_cost = new String[sl.size()];
		String[] time_cost = new String[sl.size()];
		String[] money_recharge = new String[rl.size()];
		String[] time_recharge = new String[rl.size()];
		for(int i = 0;i<sl.size();i++){
			money_cost[i] = Double.toString(sl.get(i).getTotalPrice());
			time_cost[i] = sl.get(i).getDate().substring(0,16);
			System.out.println(sl.get(i).getAid());
			System.out.println(money_cost[i]);
			System.out.println(time_cost[i]);
		}
		for(int i = 0;i<rl.size();i++){
			money_recharge[i] = Integer.toString(rl.get(i).getCost());
			time_recharge[i] = rl.get(i).getDate().substring(0,16);
		}
		sc.setAttribute("money_cost", money_cost);
		sc.setAttribute("time_cost", time_cost);
		sc.setAttribute("num_cost", time_cost.length);
		sc.setAttribute("money_recharge", money_recharge);
		sc.setAttribute("time_recharge", time_recharge);
		sc.setAttribute("num_recharge", time_recharge.length);
		
//		String[][] s = memberService.getActivityByAccount(account);//我的活动界面
//		String[] aid = s[0];
//		String[] question = s[1];
//		String[] mid = s[2];
//		String[] movie_name = s[3];
//		sc.setAttribute("aid", aid);
//		sc.setAttribute("question", question);
//		sc.setAttribute("mid", mid);
//		sc.setAttribute("movie_name", movie_name);
//		sc.setAttribute("num", aid.length);
		
		return success;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	private static boolean overOneYear(Date before,Date after){
		boolean result=false;
		if(after.getYear()-before.getYear()>1){
			result=true;
		}else if(after.getYear()-before.getYear()==1){
			if(after.getMonth()>before.getMonth()){
				result=true;
			}else if(after.getMonth()<before.getMonth()){
				result=false;
			}else{
				if(after.getDate()>before.getDate()){
					result=true;
				}else {
					result=false;
				}
			}
			
		}else{
			result=false;
		}
		
		return result;
	}
}
