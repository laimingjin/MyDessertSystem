package edu.nju.desserthouse.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.Plan;
import edu.nju.desserthouse.service.PlanService;
import edu.nju.desserthouse.service.ProductService;
import edu.nju.desserthouse.service.ShopService;

public class UpdatePlanAction extends BaseAction{
	private int pid ;
	private String product_name;
	private Date starttime;
	private String shop;
	private int quantity ;
	private int status;
	private double price ;
	private int planid ;
	private int wid;		
	
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
		setPid(Integer.parseInt(request.getParameter("pid")));
		setProduct_name(request.getParameter("product_name"));
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		setStarttime(simpleDateFormat.parse(request.getParameter("starttime")));
		setShop(request.getParameter("shop"));
		setQuantity(Integer.parseInt(request.getParameter("quantity")));	
		setPrice(Double.parseDouble(request.getParameter("price")));
		setStatus(0);
		setWid(Integer.parseInt(request.getParameter("wid")));
		Plan plan=new Plan(planid,pid, shop, starttime, quantity, status, price, wid);
		planService.updatePlan(plan);
		return success;
		
	}
	
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public String getShop() {
		return shop;
	}

	public void setShop(String shop) {
		this.shop = shop;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getPlanid() {
		return planid;
	}

	public void setPlanid(int planid) {
		this.planid = planid;
	}

	public int getWid() {
		return wid;
	}

	public void setWid(int wid) {
		this.wid = wid;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}
}
