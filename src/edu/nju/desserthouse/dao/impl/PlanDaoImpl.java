package edu.nju.desserthouse.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.dao.PlanDao;
import edu.nju.desserthouse.model.Allsale;
import edu.nju.desserthouse.model.Plan;
import edu.nju.desserthouse.model.Waiter;
import edu.nju.desserthouse.dao.BaseDao;
import hibernate3.support.YeekuHibernateDaoSupport;

public class PlanDaoImpl extends YeekuHibernateDaoSupport
implements PlanDao{

	@Autowired
	private BaseDao baseDao;
	
	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	@Override
	public boolean save(Plan plan) {
		// TODO Auto-generated method stub
		baseDao.save(plan);
		return true;
	}

	@Override
	public boolean update(Plan plan) {
		// TODO Auto-generated method stub
		System.out.println(plan.getPlanid());
		baseDao.update(plan);
		Plan p = getPlanByPlanid(plan.getPlanid());
		return p.getClass().equals(plan);
	}

	@Override
	public Plan getPlanByPlanid(int planid) {
		// TODO Auto-generated method stub
		return (Plan) baseDao.load(Plan.class, planid);
	}

	@Override
	public List<Plan> getAllPlan() {
		// TODO Auto-generated method stub
	//	String hql = "from edu.nju.desserthouse.model.Plan where starttime<current_time()";
	String hql = "from edu.nju.desserthouse.model.Plan";
		Session session = baseDao.getNewSession();
		System.out.println(session.createQuery(hql).list().size());
		
		return session.createQuery(hql).list();
	}

	

	@Override
	public boolean saveAllsale(Allsale allsale) {
		// TODO Auto-generated method stub
		baseDao.save(allsale);
		return true;
	}

	@Override
	public List<Plan> findPlanListByShop(String shop) {
		// TODO Auto-generated method stub
		List<Plan>result=new ArrayList<Plan>();
		String hql = "from edu.nju.desserthouse.model.Plan";
		Session session = baseDao.getNewSession();
		List<Plan>waiterList= session.createQuery(hql).list();
		if(waiterList.size()!=0){
			for(int i=0;i<waiterList.size();i++){
				if(waiterList.get(i).getShop().equals(shop)){
					result.add(waiterList.get(i));
				}
			}
			return result;
		}
		return null;
	}
	
}
