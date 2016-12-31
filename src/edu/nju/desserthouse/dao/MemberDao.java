package edu.nju.desserthouse.dao;

import java.util.List;

import edu.nju.desserthouse.model.Allsale;
import edu.nju.desserthouse.model.Member;
import edu.nju.desserthouse.model.Recharge;

public interface MemberDao {
	Member save(Member member);
	
	boolean saveRecharge(Recharge recharge);
	
	boolean update(Member member);
	
	boolean findByAccount(Member member);
	
	Member findByTel(Member member);
	
	boolean findByAccountAndPassword(Member member);
	
	boolean findByTelAndPassword(Member member);
	
	String getNameByAccount(int account);

	String getNameByTel(long tel);
	
	Member getMemberByAccount(int account);
	
	List<Member> getAllMembers();
	
	//List<Join_a> getJoin_a(int account);
	
	//List<Sale> getSale(int account);
	
	List<Recharge> getRecharge(int account);
	
	List<Allsale> getAllsale(int account);
}