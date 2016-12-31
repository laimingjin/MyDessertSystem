package edu.nju.desserthouse.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.Member;
import edu.nju.desserthouse.service.MemberService;

public class AllMemberAction extends BaseAction{
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
		 String[] account=new String[members.size()];
		 String[] name=new String[members.size()];
		 String[] password=new String[members.size()];
		 String[] tel=new String[members.size()];
		 String[] card=new String[members.size()];
		 String[] money=new String[members.size()];
		 String[] allcost=new String[members.size()];
		 String[] level=new String[members.size()];
		 String[] status=new String[members.size()];
		 String[] credit=new String[members.size()];
		 String[] date=new String[members.size()];
		 String[] age=new String[members.size()];
		 String[] gender=new String[members.size()];
		 String[] address=new String[members.size()];
		 
		 for(int i=0;i<members.size();i++){
			 Member member=members.get(i);
			 account[i]=Integer.toString(member.getAccount());
			 name[i]=member.getName();
			 password[i]=member.getPassword();
			 tel[i]=Long.toString(member.getTel());
			 card[i]=member.getCard();
			 money[i]=Double.toString(member.getMoney());
			 allcost[i]=Double.toString(member.getAllcost());
			 credit[i]=Integer.toString(member.getCredit());
			 SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
			 date[i]=simpleDateFormat.format(member.getDate());
			 age[i]=Integer.toString(member.getAge());
			 gender[i]=member.getGender();
			 address[i]=member.getAddress();
			 
			 switch(member.getLevel()){
				case 0:level[i]= "普卡";break;
				case 1:level[i]="银卡";break;
				case 2:level[i]="金卡";break;
				case 3:level[i]="钻石卡";break;
				default:level[i]="未知";
				}
				switch(member.getStatus()){
				case -2:status[i]="停止使用";break;
				case -1:status[i]="暂停使用";break;
				case 0:status[i]="未激活";break;
				case 1:status[i]="活跃";break;
				default:status[i]= "未知";
				}
		 }
		 sc.setAttribute("name",name);
		 sc.setAttribute("account",account);
		 sc.setAttribute("password",password);
		 sc.setAttribute("tel",tel);
		 sc.setAttribute("card",card);
		 sc.setAttribute("money",money);
		 sc.setAttribute("allcost",allcost);
		 sc.setAttribute("level",level);
		 sc.setAttribute("status",status);
		 sc.setAttribute("credit",credit);
		 sc.setAttribute("date",date);
		 sc.setAttribute("age",age);
		 sc.setAttribute("gender",gender);
		 sc.setAttribute("address",address);
		 sc.setAttribute("num", members.size());
		return success;
		
		
	}
}
