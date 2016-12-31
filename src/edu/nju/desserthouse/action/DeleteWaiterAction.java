package edu.nju.desserthouse.action;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.Waiter;
import edu.nju.desserthouse.service.WaiterService;

public class DeleteWaiterAction extends BaseAction{
private Waiter waiter;
@Autowired
private WaiterService waiterService;
public void  setWaiterService(WaiterService waiterService){
	this.waiterService=waiterService;
}
public WaiterService getWaiterService(){
	return waiterService;
}

private String success="success";
@Override
public String execute() throws Exception {
	ServletContext sc = request.getServletContext();
	String[]aa=(String[])sc.getAttribute("waiter_account");
	int account=Integer.parseInt(request.getParameter("waiter_account"));
	System.out.println(account);
	setWaiter(waiterService.getWaiterByAccount(account));
	waiterService.deleteWaiter(waiter);
	return success;
}
public void setWaiter(Waiter waiter){
	this.waiter=waiter;
}
public Waiter getWaiter(){
	return waiter;
}
}
