package edu.nju.desserthouse.action;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.Allsale;
import edu.nju.desserthouse.model.Member;
import edu.nju.desserthouse.service.AllsaleService;
import edu.nju.desserthouse.service.MemberService;

public class DeleteAllsaleAction extends BaseAction{
	@Autowired
	private AllsaleService allsaleService;
	private MemberService memberService;
	public MemberService getMemberService() {
		return memberService;
	}

	private String success = "success";

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	public void setAllsaleService(AllsaleService allsaleService){
		this.allsaleService=allsaleService;
	}
	public AllsaleService getAllsaleService(AllsaleService allsaleService){
		return allsaleService;
	}
	
	@Override
	public String execute() throws Exception {
		
		int aid=Integer.parseInt(request.getParameter("aid"));
		Allsale allsale=allsaleService.findAllsaleByAid(aid);
		allsaleService.deleteAllsale(allsale);
		
		int member_account=Integer.parseInt(request.getParameter("member_account"));
		double totalPrice=Double.parseDouble(request.getParameter("totalPrice"));
		Member member=memberService.getMemberByAccount(member_account);
		Member newMember=new Member(member.getAccount(), member.getName(), member.getPassword(), member.getTel(), member.getStatus(), member.getCredit(), member.getDate(), member.getAge(), member.getGender(), member.getAddress(), member.getCard(), member.getMoney()+totalPrice, member.getAllcost(), member.getLevel());
		memberService.update(newMember);
		
		return "success";
		
	}
}
