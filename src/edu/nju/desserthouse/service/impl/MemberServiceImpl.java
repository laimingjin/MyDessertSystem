package edu.nju.desserthouse.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import edu.nju.desserthouse.model.Allsale;
import edu.nju.desserthouse.model.Member;
import edu.nju.desserthouse.model.Recharge;
import edu.nju.desserthouse.service.MemberService;
import edu.nju.desserthouse.dao.MemberDao;

public class MemberServiceImpl implements MemberService{
	private MemberDao memberDao;
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	@Override
	public Member registerMember(Member member) {
		// TODO Auto-generated method stub
		Member m = memberDao.findByTel(member);
		if(m == null){
			System.out.println("222");
			int account = 0;
			do{
				Random r = new Random(); 
				account = r.nextInt(99999999);
			}while(account>10000000&&memberDao.getNameByAccount(account).equals(""));
			
			member.setAccount(account);
			m = memberDao.save(member);
			return m;
		}else{
			m = null;
		}
		return m;
	}

	@Override
	public boolean checkLogin(Member member) {
		// TODO Auto-generated method stub
		boolean result=false;
		result= memberDao.findByAccountAndPassword(member);
		
		return result;
	}
	@Override
	public boolean checkLoginByTel(Member member) {
		// TODO Auto-generated method stub
		boolean result=false;
		result=memberDao.findByTelAndPassword(member);
		return result;
	}

	@Override
	public String getNameByAccount(int account) {
		// TODO Auto-generated method stub
		return memberDao.getNameByAccount(account);
	}

	@Override
	public String getNameByTel(long tel) {
		// TODO Auto-generated method stub
		return memberDao.getNameByTel(tel);
	}
	
	@Override
	public Member getMemberByAccount(int account) {
		// TODO Auto-generated method stub
		return memberDao.getMemberByAccount(account);
	}

	@Override
	public void update(Member member) {
		// TODO Auto-generated method stub
		memberDao.update(member);
	}

	@Override
	public boolean setCard(int account, String password, String card) {
		// TODO Auto-generated method stub
		Member m = memberDao.getMemberByAccount(account);
		if(m.getPassword().equals(password)){
		   m.setCard(card);
		   return memberDao.update(m);
		}else{
		   return false;
		}
	}

	@Override
	public int getStatusByAccount(int account) {
		// TODO Auto-generated method stub
		Member m = memberDao.getMemberByAccount(account);
		return m.getStatus();
	}

	@Override
	public int getLevelByAccount(int account) {
		// TODO Auto-generated method stub
		Member m = memberDao.getMemberByAccount(account);
		return m.getLevel();
	}

	@Override
	public boolean recharge(int account, String password, int money) {
		// TODO Auto-generated method stub
		Member m = memberDao.getMemberByAccount(account);
		m.setAllcost(m.getAllcost()+money);
		m.setMoney(m.getMoney()+money);
		if(m.getMoney()>30){
			m.setStatus(1);
		}
		if(m.getAllcost()>1000){
			m.setLevel(1);
		}
		if(m.getAllcost()>5000){
			m.setLevel(2);
		}
		if(m.getAllcost()>10000){
			m.setLevel(3);
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String time = df.format(new Date());// new Date()为获取当前系统时间
		Recharge recharge = new Recharge(account,money,time);
		memberDao.saveRecharge(recharge);
		memberDao.update(m);
		return true;
	}

	@Override
	public boolean getCardByAccount(int account) {
		// TODO Auto-generated method stub
		Member m = memberDao.getMemberByAccount(account);
		System.out.println("card="+m.getCard());
		return m.getCard()!="null";
	}

	@Override
	public List<Allsale> getAllsaleByAccount(int account) {
		// TODO Auto-generated method stub
		return memberDao.getAllsale(account);
	}

	@Override
	public List<Recharge> getRechargeByAccount(int account) {
		// TODO Auto-generated method stub
		return memberDao.getRecharge(account);
	}

	@Override
	public List<Member> getAllMembers() {
		// TODO Auto-generated method stub
		return memberDao.getAllMembers();
	}

}
