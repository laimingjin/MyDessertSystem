package edu.nju.desserthouse.service.impl;

import java.util.List;

import edu.nju.desserthouse.dao.PlanDao;
import edu.nju.desserthouse.model.Allsale;
import edu.nju.desserthouse.model.Plan;
import edu.nju.desserthouse.service.PlanService;

public class PlanServiceImpl implements PlanService{

	private PlanDao planDao;
	public void setPlanDao(PlanDao planDao){
		this.planDao=planDao;
	}
	
	@Override
	public Plan getPlanByPlanid(int pid) {
		// TODO Auto-generated method stub
		return planDao.getPlanByPlanid(pid);
	}

	@Override
	public boolean setPlan(Plan plan) {
		// TODO Auto-generated method stub
		return planDao.save(plan);
	}

	@Override
	public boolean allowPlanByPlanid(int pid) {
		// TODO Auto-generated method stub
		Plan p = planDao.getPlanByPlanid(pid);
		p.setStatus(1);
		return planDao.update(p);
	}
	@Override
	public boolean disapprovePlanByPlanid(int pid) {
		// TODO Auto-generated method stub
		Plan p = planDao.getPlanByPlanid(pid);
		p.setStatus(-1);
		return planDao.update(p);
	}

	@Override
	public List<Plan> getAllPlan() {
		// TODO Auto-generated method stub
		return planDao.getAllPlan();
	}

	@Override
	public boolean updatePlan(Plan plan) {
		// TODO Auto-generated method stub
		return planDao.update(plan);
	}

	

	@Override
	public boolean setAllsale(Allsale allsale) {
		// TODO Auto-generated method stub
		return planDao.saveAllsale(allsale);
	}

	@Override
	public List<Plan> findPlanListByShop(String shop) {
		// TODO Auto-generated method stub
		return planDao.findPlanListByShop(shop);
	}

}
