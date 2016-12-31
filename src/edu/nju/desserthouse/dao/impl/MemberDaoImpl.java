package edu.nju.desserthouse.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.dao.MemberDao;
import edu.nju.desserthouse.model.Allsale;
import edu.nju.desserthouse.model.Member;
import edu.nju.desserthouse.model.Recharge;
import edu.nju.desserthouse.dao.BaseDao;
import hibernate3.support.YeekuHibernateDaoSupport;

public class MemberDaoImpl extends YeekuHibernateDaoSupport
implements MemberDao{

	@Autowired
	private BaseDao baseDao;
	
	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	@Override
	public Member save(Member member) {
		// TODO Auto-generated method stub
		Member m = new Member();
		// TODO Auto-generated method stub
		baseDao.save(member);
		System.out.println("save:name:"+member.getName());
		m = this.findByTel(member);
		return m;
	}

	@Override
	public boolean saveRecharge(Recharge recharge) {
		// TODO Auto-generated method stub
		baseDao.save(recharge);
		return true;
	}

	@Override
	public boolean update(Member member) {
		// TODO Auto-generated method stub
        baseDao.update(member);		
		Member m = this.getMemberByAccount(member.getAccount());
		return m.getClass().equals(member);
	}

	@Override
	public boolean findByAccount(Member member) {
		// TODO Auto-generated method stub
		List<Member> result = (List<Member>)getHibernateTemplate().
				find("from member as m where "
				+"m.account=?", member.getAccount());
		if(result.size() != 0){
			return true;
		}
		return false;
	}

	@Override
	public Member findByTel(Member member) {
		// TODO Auto-generated method stub
		Member m = null;
		String hql = "from edu.nju.desserthouse.model.Member where tel ='"+member.getTel()+"'";
		Session session = baseDao.getNewSession();
		List<Member> ml = session.createQuery(hql).list();
		if(ml.size()>0){
			m = ml.get(0);
		}
		return m;
	}

	@Override
	public boolean findByAccountAndPassword(Member member) {
		// TODO Auto-generated method stub
        Member m = (Member) baseDao.load(Member.class, member.getAccount());		
		if(m==null){
			return false;
		}
		
		//System.out.println(m.getPassword());
		if(m.getPassword().equals(member.getPassword()))
			return true;
		else
			return false;
	}

	@Override
	public boolean findByTelAndPassword(Member member) {
		// TODO Auto-generated method stub
        Member m = (Member) baseDao.load(Member.class, member.getTel());		
		if(m==null){
			return false;
		}
		
		//System.out.println(m.getPassword());
		if(m.getPassword().equals(member.getPassword()))
			return true;
		else
			return false;
	}
	
	@Override
	public String getNameByAccount(int account) {
		// TODO Auto-generated method stub
        Member m = (Member) baseDao.load(Member.class, account);		
		if(m==null){
			return "";
		}else{
			return m.getName();
		}
	}
	
	@Override
	public String getNameByTel(long tel) {
		// TODO Auto-generated method stub
        Member m = (Member) baseDao.load(Member.class, tel);		
		if(m==null){
			return "";
		}else{
			return m.getName();
		}
	}
	

	@Override
	public Member getMemberByAccount(int account) {
		// TODO Auto-generated method stub
        Member m = (Member) baseDao.load(Member.class, account);		
		return m;
	}

	@Override
	public List<Member> getAllMembers() {
		// TODO Auto-generated method stub
		String hql = "from edu.nju.desserthouse.model.Member";
		Session session = baseDao.getNewSession();
		return session.createQuery(hql).list();
	}

	@Override
	public List<Recharge> getRecharge(int account) {
		// TODO Auto-generated method stub
		String hql = "from edu.nju.desserthouse.model.Recharge where account ='"+account+"'";
		Session session = baseDao.getNewSession();
		return session.createQuery(hql).list();
	}

	@Override
	public List<Allsale> getAllsale(int account) {
		// TODO Auto-generated method stub
		String hql = "from edu.nju.desserthouse.model.Allsale where member_account ='"+account+"'";
		Session session = baseDao.getNewSession();
		return session.createQuery(hql).list();
	}

}
