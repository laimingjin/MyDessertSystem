package edu.nju.desserthouse.action;


import java.util.Date;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.service.MemberService;
import edu.nju.desserthouse.model.Member;

public class RegisterAction extends BaseAction {
	private String name;
	private long tel;
	private String password;
	private int age;
	private String gender;
	private String address;
	@Autowired
	private MemberService memberService;
	public MemberService getMemberService() {
		return memberService;
	}


	private String success = "success";
	private String input = "input";
	private String exist = "exist";

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

	public long getTel() {
		return tel;
	}

	public void setTel(long tel) {
		this.tel = tel;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(request.getParameter("name")==""||request.getParameter("password")==""||request.getParameter("confirm")==""||request.getParameter("tel")==""||request.getParameter("age")==""||request.getParameter("gender")==""||request.getParameter("address")==""){
			return input;
		}
		try{
			if(request.getParameter("password")!=null&&request.getParameter("password").equals(request.getParameter("confirm"))){
				setName(request.getParameter("name"));
				setPassword(request.getParameter("password"));
				setTel(Long.parseLong(request.getParameter("tel")));
				setAge(Integer.parseInt(request.getParameter("age")));
				setGender(request.getParameter("gender"));
				setAddress(request.getParameter("address"));
				
			}else{
				return input;
			}
			Date today=new Date();
			Member member = new Member(name, password,tel,0,0,today,age,gender,address);
			System.out.println("tel:"+member.getTel()+";"+"password:"+member.getPassword());
			Member m = memberService.registerMember(member);
			
			ServletContext sc = request.getServletContext();
			
			if(m != null){
				sc.setAttribute("accountType", "member");
				sc.setAttribute("account", Integer.toString(member.getAccount()));
				sc.setAttribute("account_name", name);
				return success;
			}else{
				return exist;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return input;
	}

}
