package edu.nju.desserthouse.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.Plan;
import edu.nju.desserthouse.service.MemberService;
import edu.nju.desserthouse.service.PlanService;

public class TestAction extends BaseAction{
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
//	String[] checkbox = request.getParameterValues("checkbox");   
//	List<Integer> checkboxs = new ArrayList<Integer>();   
//	//判断复选框是否有选   
//	if(checkbox!=null&&!"".equals(checkbox)){   
//	for(int i=0;i<checkbox.length;i++){   
//	//checkboxs.add(checkbox[i]);   
//	String id_str = checkbox[i];   
//	int id = Integer.parseInt(id_str);  
//	System.out.println(id);
//	}
//	}
		Plan plan=planService.getPlanByPlanid(7);
		System.out.println(plan.getPid());
		System.out.println(plan.getPlanid());
		
	return "success";
}
}