package edu.nju.desserthouse.action;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.Member;
import edu.nju.desserthouse.service.MemberService;

public class StopMemberAction extends BaseAction{
	@Autowired
	private MemberService memberService;
	public MemberService getMemberService() {
		return memberService;
	}
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public String execute() throws Exception {
		int account=Integer.parseInt((String)request.getParameter("stop_account"));
		Member m=memberService.getMemberByAccount(account);
		m.setStatus(-2);
		memberService.update(m);
		return "success";
	}
}
