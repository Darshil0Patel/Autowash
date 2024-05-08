package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bean.Customer;
import com.Bean.ServiceMan;
import com.Bean.pending;
import com.dao.CustomerDao;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("signup"))
		{
			Customer cus = new Customer();
			cus.setFname(request.getParameter("fname"));
			cus.setLname(request.getParameter("lname"));
			cus.setEmail(request.getParameter("email"));
			cus.setPassword(request.getParameter("password"));
			System.out.println(cus.getFname());
			CustomerDao.insertCustomer(cus);
			response.sendRedirect("Customer-login.jsp");
		}
		if(action.equalsIgnoreCase("login"))
		{
			PrintWriter out = response.getWriter();
			Customer c = new Customer();
			c.setEmail(request.getParameter("email"));
			c.setPassword(request.getParameter("password"));
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			Customer c1 = CustomerDao.loginCustomer(c);
			System.out.println(email);
			System.out.println(password);
			try {
				if(c1.getEmail().equalsIgnoreCase(email)&&c1.getPassword().equalsIgnoreCase(password))
				{
					HttpSession session = request.getSession();
					session.setAttribute("abc", c1);
					response.sendRedirect("customerdetail.jsp");
//					request.getRequestDispatcher("customerdetail.jsp").forward(request, response);
				}
			} catch (NullPointerException e) {
				// TODO: handle exception
				out.print("Please register yourself if not!!");
				response.sendRedirect("Customer-register.jsp");
			}
			
			if(email==""||password=="")
			{
				out.print("fields cannot be blank");
				response.sendRedirect("Customer-register.jsp");
			}
			else if(email==null || password==null)
			{
				out.print("fields cannot be null");
				response.sendRedirect("Customer-register.jsp");
			}
//			else if(c1.getEmail().equalsIgnoreCase(email)&&c1.getPassword().equalsIgnoreCase(password))
//			{
//				HttpSession session = request.getSession();
//				session.setAttribute("abc", c1);
//				request.getRequestDispatcher("customerdetail.jsp").forward(request, response);
//			}
//			else
//			{
//				System.out.println(c1.getEmail()+","+c.getEmail());
//				System.out.println(c1.getPassword()+","+c.getPassword());
//				out.print("Please register yourself if not!!");
//			}
		}
		if(action.equalsIgnoreCase("update"))
		{
			Customer c = new Customer();
			c.setId(Integer.parseInt(request.getParameter("id")));
			c.setFname(request.getParameter("fname"));
			c.setLname(request.getParameter("lname"));
			c.setEmail(request.getParameter("email"));
			c.setPassword(request.getParameter("password"));
			CustomerDao.updateCustomer(c);
			HttpSession session = request.getSession();
			session.setAttribute("abc", c);
			response.sendRedirect("customerdetail.jsp");
		}
		if(action.equalsIgnoreCase("exteriorwashing"))
		{
			response.sendRedirect("exteriorwashing.jsp");
		}
		if(action.equalsIgnoreCase("interiorwashing"))
		{
			response.sendRedirect("interiorwashing.jsp");
		}
		if(action.equalsIgnoreCase("vacuumcleaning"))
		{
			response.sendRedirect("vacuumcleaning.jsp");
		}
		if(action.equalsIgnoreCase("seatswashing"))
		{
			response.sendRedirect("seatswashing.jsp");
		}
		if(action.equalsIgnoreCase("windowwiping"))
		{
			response.sendRedirect("windowwiping.jsp");
		}
		if(action.equalsIgnoreCase("wetcleaning"))
		{
			response.sendRedirect("wetcleaning.jsp");
		}
		if(action.equalsIgnoreCase("oilchanging"))
		{
			response.sendRedirect("oilchanging.jsp");
		}
		if(action.equalsIgnoreCase("brakereparing"))
		{
			response.sendRedirect("brakereparing.jsp");
		}
		
		if(action.equalsIgnoreCase("confirm"))
		{
			pending p = new pending();
			int cid = Integer.parseInt(request.getParameter("cid"));
			int sid = Integer.parseInt(request.getParameter("sid"));
			String cfname = request.getParameter("cfname");
			String sfname = request.getParameter("sfname");
			String clname = request.getParameter("clname");
			String slname = request.getParameter("slname");
			String cemail = request.getParameter("cemail");
			String semail = request.getParameter("semail");
			String ServiceID = request.getParameter("ServiceID");
			String service = request.getParameter("service");
			
			p.setCid(cid);
			p.setSid(sid);
			p.setCfname(cfname);
			p.setSfname(sfname);
			p.setClname(clname);
			p.setSlname(slname);
			p.setCemail(cemail);
			p.setSemail(semail);
			p.setServiceID(ServiceID);
			p.setService(service);
			
			System.out.println(p.getCid());
			System.out.println(p.getSid());
			System.out.println(p.getCfname());
			System.out.println(p.getCemail());
			System.out.println(p.getSfname());
			System.out.println(p.getClname());
			System.out.println(p.getSlname());
			System.out.println(p.getSemail());
			System.out.println(p.getServiceID());
			System.out.println(p.getService());
			
			pending pe = CustomerDao.getpendingdata(cid, sid);
		 
			try {
				if(cid==pe.getCid() && sid==pe.getSid())
				{
					response.sendRedirect("status.jsp");
				}
				
			} catch (NullPointerException e) {
				// TODO: handle exception
				CustomerDao.insertpending(p);
				response.sendRedirect("status.jsp");
				
			}
		}
	}

}
