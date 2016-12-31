package edu.nju.desserthouse.service.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.User;
import edu.nju.desserthouse.service.UserManageService;
import edu.nju.desserthouse.dao.UserDao;

public class UserManagerServiceImpl implements UserManageService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public User validateUser(String userid, String password) {
		// TODO Auto-generated method stub
		User user=userDao.find("userid",userid);
		if(user==null)
		{
			return null;
		}
		else if(!user.getPassword().equals(password))
		{
			return null;
		}
		
		return user;
	}

	@Override
	public Integer validateNumber(String number) {
		// TODO Auto-generated method stub
		Integer num=null;
		try
		{
			num=Integer.valueOf(number);
		}
		catch(Exception e)
		{
			return null;
		}
		
		if(num.intValue()<=0)
		{
			return null;
		}
		
		return num;
	}

	@Override
	public void sentErrorMessage(String message, HttpServletRequest req) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setAttribute("message",message);
//		RequestDispatcher dispater=req.getRequestDispatcher(resp.encodeURL("/error/error.jsp"));
//		dispater.forward(req,resp);
	}

	@Override
	public void sentMessage(String message, HttpServletRequest req) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setAttribute("message",message);
//		RequestDispatcher dispater=req.getRequestDispatcher(resp.encodeURL("/message/message.jsp"));
//		dispater.forward(req,resp);
	}

	@Override
	public void forwardPage(String page, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispater=req.getRequestDispatcher(resp.encodeURL(page));
		dispater.forward(req,resp);
	}

	@Override
	public String registerUser(User user) {
		// TODO Auto-generated method stub
		String message=null;
		/*	if(validateUser(user.getUserid(), user.getPasswordOne())!=null ){
				message="username exist";
				return message;
			}
	/*		else if(validateUpdateUser(user, message)!=null){
				message="All the content must be filled!";
				return message;
			}*/
		//	else{
			System.out.println(" Ready to save user");
			if(userDao==null)
				System.out.println(" userDao is null");
			userDao.save(user);
				
			return message;
		//	}
	}

	@Override
	public String test() {
		// TODO Auto-generated method stub
		return null;
	}

}
