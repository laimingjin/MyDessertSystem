package edu.nju.desserthouse.service;

import java.util.List;

import edu.nju.desserthouse.model.Plan;
import edu.nju.desserthouse.model.Allsale;

public interface PlanService {
	
	Plan getPlanByPlanid(int pid);
	
	boolean setPlan(Plan plan);//添加放映计划
	
	boolean allowPlanByPlanid(int pid);//经理批准放映计划
	boolean disapprovePlanByPlanid(int pid);//经理不批准放映计划
	
	List<Plan> getAllPlan();//根据系统时间获取放映开始时间在当前系统时间之后的放映计划
	
	boolean updatePlan(Plan plan);//经理未批准，服务员修改放映计划
	
	//String[] getAllSale(int pid);
	
	//boolean setSale(Sale sale);
	
	boolean setAllsale(Allsale allsale);
	List<Plan>findPlanListByShop(String shop);
	
}