package edu.nju.desserthouse.action;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.Member;
import edu.nju.desserthouse.service.MemberService;

public class Card_statusAction extends BaseAction{
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
		int[] active=new int[6];
		int[] pause=new int[6];
		int[] stop=new int[6];
		 for(int i=0;i<members.size();i++){
		 Member member=members.get(i);
		 System.out.println(member.getAge());
			if(member.getAge()<20){
				if(member.getStatus()==1){
					active[0]++;
				}else if(member.getStatus()==-1){
					pause[0]++;
				}else if(member.getStatus()==-2){
					stop[0]++;
				}
			}else if(member.getAge()>=20 && member.getAge()<30){
				if(member.getStatus()==1){
					active[1]++;
				}else if(member.getStatus()==-1){
					pause[1]++;
				}else if(member.getStatus()==-2){
					stop[1]++;
				}
			}else if(member.getAge()>=30 && member.getAge()<40){
				if(member.getStatus()==1){
					active[2]++;
				}else if(member.getStatus()==-1){
					pause[2]++;
				}else if(member.getStatus()==-2){
					stop[2]++;
				}
			}else if(member.getAge()>=40 && member.getAge()<50){
				if(member.getStatus()==1){
					active[3]++;
				}else if(member.getStatus()==-1){
					pause[3]++;
				}else if(member.getStatus()==-2){
					stop[3]++;
				}
			}else if(member.getAge()>=50 && member.getAge()<60){
				if(member.getStatus()==1){
					active[4]++;
				}else if(member.getStatus()==-1){
					pause[4]++;
				}else if(member.getStatus()==-2){
					stop[4]++;
				}
			}else {
				if(member.getStatus()==1){
					active[5]++;
				}else if(member.getStatus()==-1){
					pause[5]++;
				}else if(member.getStatus()==-2){
					stop[5]++;
				}
			}
			
		 }
		 sc.setAttribute("active", active);
		 sc.setAttribute("pause", pause);
		 sc.setAttribute("stop", stop);
		 return success;
	}
}
