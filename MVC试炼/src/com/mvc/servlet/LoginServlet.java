package com.mvc.servlet;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.factory.DAOFactory;
import com.mvc.vo.User;

public class LoginServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws Exception
	{
		String path = "login.jsp";
		String userid = request.getParameter("userid");
		String userpass = request.getParameter("userpass");
		List<String> info = new ArrayList<String>();
		if (userid == null || "".equals(userid))
		{
			info.add("User Id should not be null");
		}
		if (userpass == null || "".equals(userpass))
		{
			info.add("Password should not be null");
		}
		if (info.size() == 0)
		{
			User user = new User();
			user.setUserid(userid);
			user.setPassword(userpass);
			try
			{
				if (DAOFactory.getIUserDAOInstance().findLogin(user))
				{
					info.add("Welcome to " + user.getNmae() + " !");
				}
				else
				{
					info.add("Failed!");
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		request.setAttribute("info", info);
		request.getRequestDispatcher(path).forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws Exception
	{
		doGet(request, response);
	}
}
