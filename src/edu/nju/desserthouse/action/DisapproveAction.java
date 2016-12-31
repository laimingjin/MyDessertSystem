package edu.nju.desserthouse.action;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.Plan;
import edu.nju.desserthouse.service.PlanService;

public class DisapproveAction extends BaseAction{
	private String success = "success";
	private String index = "index";
	
	@Autowired
	private PlanService planService;
	public PlanService getPlanService() {
		return planService;
	}

	public void setPlanService(PlanService planService) {
		this.planService = planService;
	}
	
	@Override
	public String execute() throws Exception {
		int planid=Integer.parseInt(request.getParameter("planid"));
		Plan plan=planService.getPlanByPlanid(planid);
		planService.disapprovePlanByPlanid(planid);
		return success;
		
	}
}
