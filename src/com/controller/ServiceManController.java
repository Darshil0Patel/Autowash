package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bean.ServiceMan;
import com.dao.ServiceManDao;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/ServiceManController")
public class ServiceManController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("signup"))
		{
			ServiceMan sm = new ServiceMan();
			
			sm.setServiceID(request.getParameter("serviceID"));
			sm.setFname(request.getParameter("fname"));
			sm.setLname(request.getParameter("lname"));
			sm.setEmail(request.getParameter("email"));
			sm.setPassword(request.getParameter("password"));
			sm.setService(request.getParameter("service"));
			ServiceManDao.insertServiceMan(sm);
			response.sendRedirect("Serviceman-login.jsp");
		}
		if(action.equalsIgnoreCase("login"))
		{
			PrintWriter out = response.getWriter();
			ServiceMan sm = new ServiceMan();
			sm.setServiceID(request.getParameter("id"));
			sm.setPassword(request.getParameter("password"));
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			ServiceMan s2  = ServiceManDao.loginServiceMan(sm);
			try {
			 if(id.equals(s2.getServiceID()) && password.equals(s2.getPassword()))
				{
					HttpSession session = request.getSession();
					session.setAttribute("abc", s2);
					response.sendRedirect("servicemandetail.jsp");
				}
			} catch (NullPointerException e) {
				// TODO: handle exception
				response.sendRedirect("Serviceman-register.jsp");
			}
			if(id=="" || password=="")
			{
				out.print("fields cannot be blank!!");
				request.getRequestDispatcher("Serviceman-login.jsp");
			}
			else if(id==null || password==null)
			{
				out.print("field cannot be null !!!");
				request.getRequestDispatcher("Serviceman-login.jsp");
			}
				
			
		}
		if(action.equalsIgnoreCase("update"))
		{
			ServiceMan s = new ServiceMan();
			s.setId(Integer.parseInt(request.getParameter("id")));
			s.setServiceID(request.getParameter("serviceID"));
			s.setFname(request.getParameter("fname"));
			s.setLname(request.getParameter("lname"));
			s.setEmail(request.getParameter("email"));
			s.setPassword(request.getParameter("password"));
			s.setService(request.getParameter("service"));
			ServiceManDao.updateServiceMan(s);
			HttpSession session = request.getSession();
			session.setAttribute("abc", s);
			response.sendRedirect("servicemandetail.jsp");
			
		}
	}

}
