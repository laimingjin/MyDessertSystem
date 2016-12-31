package edu.nju.desserthouse.dao;

import java.util.List;

import edu.nju.desserthouse.model.Allsale;
import edu.nju.desserthouse.model.Plan;
//import edu.nju.onlinestock.model.Sale;

public interface PlanDao {
	boolean save(Plan plan);
	
	boolean update(Plan plan);

	
	List<Plan> getAllPlan();

	//String[] getAllSale(int pid);

	boolean saveAllsale(Allsale allsale);

	//boolean saveSale(Sale sale);
	public Plan getPlanByPlanid(int planid);
	List<Plan>findPlanListByShop(String shop);
}