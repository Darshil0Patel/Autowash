package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bean.Admin;
import com.Bean.Customer;
import com.Bean.ServiceMan;
import com.Bean.approved;
import com.Bean.pending;
import com.dao.AdminDao;
import com.dao.CustomerDao;
import com.dao.ServiceManDao;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
		
			String action = request.getParameter("action");	
			if(action.equalsIgnoreCase("login"))
			{
				Admin a = new Admin();
				String name = request.getParameter("name");
				String password = request.getParameter("password");
				a.setName(name);
				a.setPassword(password);
				Admin a2 = AdminDao.loginAdmin(a);
				try {
					if(a2.getName().equalsIgnoreCase(name) && a2.getPassword().equalsIgnoreCase(password))
					{
						HttpSession session = request.getSession();
						session.setAttribute("abc", a);
						response.sendRedirect("admin-index.jsp");
					}
				} catch (NullPointerException e) {
					// TODO: handle exception
					request.getRequestDispatcher("admin-login.jsp").forward(request, response);
					
				}
				
			}
			
			if(action.equalsIgnoreCase("addCustomer"))
			{
				Customer cus = new Customer();
				cus.setFname(request.getParameter("fname"));
				cus.setLname(request.getParameter("lname"));
				cus.setEmail(request.getParameter("email"));
				cus.setPassword(request.getParameter("password"));
				System.out.println(cus.getFname());
				AdminDao.insertCustomer(cus);
				response.sendRedirect("Customer-data.jsp");
				
			}
			
			if(action.equalsIgnoreCase("addServiceMan"))
			{
				ServiceMan sm = new ServiceMan();
				
				sm.setServiceID(request.getParameter("serviceID"));
				sm.setFname(request.getParameter("fname"));
				sm.setLname(request.getParameter("lname"));
				sm.setEmail(request.getParameter("email"));
				sm.setPassword(request.getParameter("password"));
				sm.setService(request.getParameter("service"));
				AdminDao.insertServiceMan(sm);
				response.sendRedirect("ServiceMan-data.jsp");
			}
			
			if(action.equalsIgnoreCase("updatecustomerpage"))
			{
				int id = Integer.parseInt(request.getParameter("id"));
				Customer cs = AdminDao.getCustomerData(id);
				request.setAttribute("cs", cs);
				request.getRequestDispatcher("UpdateCustomer-data.jsp").forward(request, response);
			}
			
			if(action.equalsIgnoreCase("UpdateCustomer"))
			{
				Customer c = new Customer();
				c.setId(Integer.parseInt(request.getParameter("id")));
				c.setFname(request.getParameter("fname"));
				c.setLname(request.getParameter("lname"));
				c.setEmail(request.getParameter("email"));
				c.setPassword(request.getParameter("password"));
				AdminDao.updateCustomer(c);
				response.sendRedirect("Customer-data.jsp");
			}
			
			if(action.equalsIgnoreCase("deletecustomerpage"))
			{
				int id = Integer.parseInt(request.getParameter("id"));
				System.out.println(id);
				AdminDao.deleteCustomer(id);
				response.sendRedirect("Customer-data.jsp");
			}
			
			if(action.equalsIgnoreCase("updateservicemanpage"))
			{
				int id = Integer.parseInt(request.getParameter("id"));
				ServiceMan sm = AdminDao.getServiceManData(id);
				request.setAttribute("sc", sm);
				request.getRequestDispatcher("UpdateServiceMan-data.jsp").forward(request, response);
				
			}
			
			if(action.equalsIgnoreCase("UpdateServiceMan"))
			{
				ServiceMan sm = new ServiceMan();
				sm.setId(Integer.parseInt(request.getParameter("id")));
				sm.setServiceID(request.getParameter("serviceID"));
				sm.setFname(request.getParameter("fname"));
				sm.setLname(request.getParameter("lname"));
				sm.setEmail(request.getParameter("email"));
				sm.setPassword(request.getParameter("password"));
				sm.setService(request.getParameter("service"));
				AdminDao.updateServiceMan(sm);
				response.sendRedirect("ServiceMan-data.jsp");
			}
			
			if(action.equalsIgnoreCase("deleteservicemanpage"))
			{
				int id = Integer.parseInt(request.getParameter("id"));
				System.out.println(id);
				AdminDao.deleteServiceMan(id);
				response.sendRedirect("ServiceMan-data.jsp");
			}
			
			if(action.equalsIgnoreCase("approve"))
			{
				pending p = new pending();
				int id = Integer.parseInt(request.getParameter("id"));
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
				
				p.setId(id);
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
				
				AdminDao.deletePendingService(id);
				AdminDao.insertApprovedService(p);
				response.sendRedirect("adminpending.jsp");
			}
			
			if(action.equalsIgnoreCase("pending"))
			{
				approved p = new approved();
				int id = Integer.parseInt(request.getParameter("id"));
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
				
				p.setId(id);
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
				
				AdminDao.deleteApprovedService(id);
				AdminDao.insertPendingService(p);
				response.sendRedirect("adminapproved.jsp");
			}
			
		}

}
