package edu.nju.desserthouse.action;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.service.MemberService;
import edu.nju.desserthouse.model.Member;

public class CardAction extends BaseAction {
	private String name;
	private String password;
	private String card;
	private int money;
	
	@Autowired
	private MemberService memberService;
	public MemberService getMemberService() {
		return memberService;
	}


	private String success = "success";
	private String input = "input";
	private String mon = "money";
	private String car = "card";
	private String stop = "stop";

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}


	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}


	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(request.getParameter("password")==""||request.getParameter("money")==""){
			return input;
		}
		try{
			setMoney(Integer.parseInt(request.getParameter("money")));
			setPassword(request.getParameter("password"));
			
			ServletContext sc = request.getServletContext();
			int account = Integer.parseInt((String) sc.getAttribute("account"));

			if(request.getParameter("card").equals("null")){//第一次充值
				return car;
				
			}else{
				if(request.getParameter("status").equals("未激活")){
					if(money<200){
						memberService.setCard(account, password, "null");
						System.out.println("money<200");
						return mon;
					}else{
						memberService.setCard(account, password, request.getParameter("card"));
						if(memberService.recharge(account, password, money)){
							sc.setAttribute("card", request.getParameter("card"));
							return success;
						}
					}
				
				
				
				}else{
					if(request.getParameter("status").equals("停止使用")){
						return stop;
						
					}
					memberService.setCard(account, password, request.getParameter("card"));
					if(memberService.recharge(account, password, money)){
						sc.setAttribute("card", request.getParameter("card"));
						return success;
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("return input");
		return input;
	}

}
