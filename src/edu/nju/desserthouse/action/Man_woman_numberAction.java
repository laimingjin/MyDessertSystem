package edu.nju.desserthouse.action;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.sun.glass.ui.Menu;

import edu.nju.desserthouse.model.Member;
import edu.nju.desserthouse.service.MemberService;

public class Man_woman_numberAction extends BaseAction{
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
		
		List<Member >members=memberService.getAllMembers();
		int[] man=new int[6];
		int[] woman=new int[6];
		 for(int i=0;i<members.size();i++){
		 Member member=members.get(i);
		 System.out.println(member.getAge());
		 if(member.getGender().equals("男")){
			if(member.getAge()<20){
				man[0]++;
			}else if(member.getAge()>=20 && member.getAge()<30){
				man[1]++;
			}else if(member.getAge()>=30 && member.getAge()<40){
				man[2]++;
			}else if(member.getAge()>=40 && member.getAge()<50){
				man[3]++;
			}else if(member.getAge()>=50 && member.getAge()<60){
				man[4]++;
			}else {
				man[5]++;
			}
			
		 }else{
			 if(member.getAge()<20){
					woman[0]++;
				}else if(member.getAge()>=20 && member.getAge()<30){
					woman[1]++;
				}else if(member.getAge()>=30 && member.getAge()<40){
					woman[2]++;
				}else if(member.getAge()>=40 && member.getAge()<50){
					woman[3]++;
				}else if(member.getAge()>=50 && member.getAge()<60){
					woman[4]++;
				}else {
					woman[5]++;
				}
		 }
		 }
		 System.out.println("num"+man[1]);
		 sc.setAttribute("woman", woman);
		 sc.setAttribute("man", man);
		 return success;
	}
	
	
}
