package edu.nju.desserthouse.action;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.Allsale;
import edu.nju.desserthouse.model.Member;
import edu.nju.desserthouse.service.AllsaleService;
import edu.nju.desserthouse.service.MemberService;

public class CountSaleAction extends BaseAction{

	@Autowired
	private MemberService memberService;
	private AllsaleService allsaleService;
	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	public AllsaleService getAllsaleService() {
		return allsaleService;
	}

	public void setAllsaleService(AllsaleService allsaleService) {
		this.allsaleService = allsaleService;
	}
	@Override
	public String execute() throws Exception {
		ServletContext sc = request.getServletContext();
		
		List<Allsale>AllsaleList=allsaleService.getAllsales();
		double[] man=new double[6];
		double[] woman=new double[6];
		for(int i=0;i<AllsaleList.size();i++){
			Allsale allsale=AllsaleList.get(i);
			int member_acount=allsale.getMember_account();
			double price=allsale.getTotalPrice();
			if(member_acount>0){
				Member member=memberService.getMemberByAccount(member_acount);
				 if(member.getGender().equals("男")){
						if(member.getAge()<20){
							man[0]+=price;
						}else if(member.getAge()>=20 && member.getAge()<30){
							man[1]+=price;
						}else if(member.getAge()>=30 && member.getAge()<40){
							man[2]+=price;
						}else if(member.getAge()>=40 && member.getAge()<50){
							man[3]+=price;
						}else if(member.getAge()>=50 && member.getAge()<60){
							man[4]+=price;
						}else {
							man[5]+=price;
						}
						
					 }else{
						 if(member.getAge()<20){
								woman[0]+=price;
							}else if(member.getAge()>=20 && member.getAge()<30){
								woman[1]+=price;
							}else if(member.getAge()>=30 && member.getAge()<40){
								woman[2]+=price;
							}else if(member.getAge()>=40 && member.getAge()<50){
								woman[3]+=price;
							}else if(member.getAge()>=50 && member.getAge()<60){
								woman[4]+=price;
							}else {
								woman[5]+=price;
							}
					 }
			}
			
			 
			
		}
		sc.setAttribute("woman", woman);
		 sc.setAttribute("man", man);
		 return "success";
		
		
		
		
		
	}
}
