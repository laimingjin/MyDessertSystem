package edu.nju.desserthouse.action;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.service.MemberService;
import edu.nju.desserthouse.service.SystemManagerService;
import edu.nju.desserthouse.model.Member;
import edu.nju.desserthouse.model.SystemManager;
import edu.nju.desserthouse.service.WaiterService;
import edu.nju.desserthouse.model.Waiter;
import edu.nju.desserthouse.service.ManagerService;
import edu.nju.desserthouse.model.Manager;

//public class LoginAction implements Action {
public class LoginAction extends BaseAction {
	/**
	 * 
	 */
	private int account;
	private String password;
	private long tel;
	public WaiterService getWaiterService() {
		return waiterService;
	}

	public void setWaiterService(WaiterService waiterService) {
		this.waiterService = waiterService;
	}

	public ManagerService getManagerService() {
		return managerService;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}
	public SystemManagerService getSystemManagerService() {
		return systemManagerService;
	}

	public void setSystemManagerService(SystemManagerService managerService) {
		this.systemManagerService = managerService;
	}
	public MemberService getMemberService() {
		return memberService;
	}
    public void setMemberService(MemberService memberService){
    	this.memberService=memberService;
    }

	
	
	@Autowired
	private MemberService memberService;
	private WaiterService waiterService;
	private ManagerService managerService;
	private SystemManagerService systemManagerService;
	private String success_member = "member";
	private String fendian_waiter = "fendian_waiter";
	private String zongdian_waiter = "zongdian_waiter";
	private String success_manager="manager";
	private String success_systemmanager="systemmanager";
	private String input = "input";

	private String ISBOUND = "cardIsBound";
	
	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public long getTel() {
		return tel;
	}

	public void setTel(long tel) {
		this.tel = tel;
	}


	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(request.getParameter("account")==""||request.getParameter("password")==""){
			return input;
		}
		try{
			setAccount(Integer.parseInt(request.getParameter("account")));
			setPassword(request.getParameter("password"));
			Member member = new Member(account, password);
			Waiter waiter = new Waiter(account, password);
			Manager manager = new Manager(account, password);
			SystemManager systemManager=new SystemManager(account,password);
			//System.out.println("account:"+waiter.getAccount()+";"+"password:"+manager.getPassword());
			
			ServletContext sc = request.getServletContext();
			
			if(memberService.checkLogin(member)){
				sc.setAttribute("accountType", "member");
				sc.setAttribute("account", Integer.toString(member.getAccount()));
				String name = memberService.getNameByAccount(account);
				sc.setAttribute("account_name", name);
				System.out.println("member");
				return success_member;
			}else if(waiterService.checkLogin(waiter)){
				sc.setAttribute("accountType", "waiter");
				sc.setAttribute("account", Integer.toString(waiter.getAccount()));
				String name = waiterService.getNameByAccount(account);
				sc.setAttribute("account_name", name);
				System.out.println("waiter");
				Waiter w=waiterService.getWaiterByAccount(account);
				System.out.println(w.getLevel());
				if(w.getLevel().equals("分店服务员")){
					return fendian_waiter;
				}else{
					return zongdian_waiter;
				}
			}else if(managerService.checkLogin(manager)){
				sc.setAttribute("accountType", "manager");
				sc.setAttribute("account", Integer.toString(manager.getAccount()));
				String name = managerService.getNameByAccount(account);
				sc.setAttribute("account_name", name);
				System.out.println("manager");
				return success_manager;
			}else if(systemManagerService.checkLogin(systemManager)){
				sc.setAttribute("accountType", "systemmanager");
				sc.setAttribute("account", Integer.toString(systemManager.getAccount()));
				String name = systemManagerService.getNameByAccount(account);
				sc.setAttribute("account_name", name);
				System.out.println("systemmanager");
				return success_systemmanager;
			}
			else{
				setTel(Long.parseLong(request.getParameter("account")));
				setPassword(request.getParameter("password"));
				Member member1 = new Member(tel, password);
				if(memberService.checkLoginByTel(member1)){
					sc.setAttribute("accountType", "member");
					sc.setAttribute("tel", Long.toString(member1.getTel()));
					String name = memberService.getNameByTel(account);
					sc.setAttribute("account_name", name);
					System.out.println("member");
					return success_member;
				}
				
				return input;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return input;
	}

}
