package edu.nju.desserthouse.action;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.Member;
import edu.nju.desserthouse.service.MemberService;

public class Man_womanAction extends BaseAction{
	private String success = "success";
	private String index = "index";
	
	@Autowired
	private MemberService memberService;
	public MemberService getMemberService(MemberService memberService){
		return memberService;
	}
	public void setMemberService(MemberService  memberService){
		this.memberService=memberService;
	}
	
	@Override
	public String execute() throws Exception {
		ServletContext sc = request.getServletContext();
		int man=0;
		int woman=0;
		List<Member >members=memberService.getAllMembers();
		 for(int i=0;i<members.size();i++){
		 Member member=members.get(i);
		 if(member.getGender().equals("男")){
			 man++;
		 }else{
			 woman++;
		 }
		 }
		 
		 sc.setAttribute("woman", woman);
		 sc.setAttribute("man", man);
		 return success;
	}
	
	
}
