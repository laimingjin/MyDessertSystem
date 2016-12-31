package edu.nju.desserthouse.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.Member;
import edu.nju.desserthouse.service.MemberService;

public class UpdateMemberAction extends BaseAction{
	private int account;
	private String name;
	private String password;
	private long tel;
	private String card;
	private double money;
	private double allcost;
	private int level;
	private int status;
	private int credit;
	private Date date;
	private int age;
	private String gender;
	private String address;
	
	@Autowired
	private MemberService memberService;
	public MemberService getMemberService(){
		return memberService;
	}
	public void setMemberService(MemberService memberService){
		this.memberService=memberService;
	}
	
	@Override
	public String execute() throws Exception{
	
//	 setAccount(Integer.parseInt(request.getParameter("account")));
//		setName(request.getParameter("name"));
//		setPassword(request.getParameter("password"));
//		setAge(Integer.parseInt(request.getParameter("age")));
//		setAddress(request.getParameter("address"));
//	    setGender(request.getParameter("gender"));
//	    setCard(request.getParameter("card"));
//	    setTel(Long.parseLong(request.getParameter("tel")));
//	    setStatus(Integer.parseInt(request.getParameter("status")));
//		setCredit(Integer.parseInt(request.getParameter("credit")));
//		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
//		setDate(simpleDateFormat.parse(request.getParameter("date")));
//		setMoney(Double.parseDouble(request.getParameter("money")));
//		setAllcost(Double.parseDouble(request.getParameter("allcost")));
//		setLevel(Integer.parseInt(request.getParameter("level")));
		 account=(Integer.parseInt(request.getParameter("account")));
			name=(request.getParameter("name"));
			password=(request.getParameter("password"));
			age=(Integer.parseInt(request.getParameter("age")));
			address=(request.getParameter("address"));
		    gender=(request.getParameter("gender"));
		    card=(request.getParameter("card"));
		    tel=(Long.parseLong(request.getParameter("tel")));
		    String tem=request.getParameter("status");
		   if(tem.equals("未激活")){
			   status=0;
		   }else if(tem.equals("暂停")){
			   status=-1;
		   }else if(tem.equals("激活") || tem.equals("恢复")){
			   status=1;
		   }else if(tem.equals("停止")){
			   status=-2;
		   }
		    
			credit=(Integer.parseInt(request.getParameter("credit")));
			SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
			date=(simpleDateFormat.parse(request.getParameter("date")));
			
//			System.out.println("money="+request.getParameter("money"));
//			System.out.println("allcost="+request.getParameter("allcost"));
			money=(Double.parseDouble(request.getParameter("money")));
			allcost=(Double.parseDouble(request.getParameter("allcost")));
			String level_temp=request.getParameter("level");
			if(level_temp.equals("普卡")){
				level=0;
			}else if(level_temp.equals("银卡")){
				level=1;
			}else if(level_temp.equals("金卡")){
				level=2;
			}
			else if(level_temp.equals("钻石卡")){
				level=3;
			}
			//level=(Integer.parseInt(request.getParameter("level")));
	    Member member=new Member( account,name,  password,  tel,  status,  credit, date,age, gender, address, card,money,allcost,level);
	    memberService.update(member);
	System.out.println("success");
	return "success";
	}
}
