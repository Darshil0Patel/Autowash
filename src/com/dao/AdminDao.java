package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Bean.Admin;
import com.Bean.Customer;
import com.Bean.ServiceMan;
import com.Bean.approved;
import com.Bean.pending;
import com.util.ConnectionSetup;

public class AdminDao {
	
	public static Admin loginAdmin(Admin a)
	{
		Admin a1 = null;
		Connection conn = ConnectionSetup.createConnection();
		try {
			String sql = "select * from admin where name=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, a.getName());
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				a1 = new Admin();
				a1.setName(rs.getString(1));
				a1.setPassword(rs.getString(2));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return a1 ;
		
	}
	
	public static List<Customer> CustomerData()
	{
		List<Customer> list = new ArrayList<Customer>();
		try {
			Connection conn = ConnectionSetup.createConnection();
			String sql = "select * from customer";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				Customer c = new Customer();
				c.setId(rs.getInt(1));
				c.setFname(rs.getString(2));
				c.setLname(rs.getString(3));
				c.setEmail(rs.getString(4));
				c.setPassword(rs.getString(5));
				list.add(c);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		return list;
		
	}
	
	public static List<ServiceMan> ServiceManData()
	{
		List<ServiceMan> list = new ArrayList<ServiceMan>();
		try {
			Connection conn = ConnectionSetup.createConnection();
			String sql = "select * from serviceman";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				ServiceMan s = new ServiceMan();
				s.setId(rs.getInt(1));
				s.setServiceID(rs.getString(2));
				s.setFname(rs.getString(3));
				s.setLname(rs.getString(4));
				s.setEmail(rs.getString(5));
				s.setPassword(rs.getString(6));
				s.setService(rs.getString(7));
				list.add(s);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		return list;
		
	}
	
	public static void insertCustomer(Customer cus)
	{
		Connection conn = ConnectionSetup.createConnection();
		String fname = cus.getFname();
		String lname = cus.getLname();
		String email = cus.getEmail();
		String password = cus.getPassword();
	
		try {
			String sql = "insert into customer(fname,lname,email,password) values(?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, fname);
			pst.setString(2, lname);
			pst.setString(3, email);
			pst.setString(4, password);
			pst.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void insertServiceMan(ServiceMan sm)
	{
		Connection conn = ConnectionSetup.createConnection();
		String ServiceID = sm.getServiceID();
		String fname = sm.getFname();
		String lname = sm.getLname();
		String email = sm.getEmail();
		String password = sm.getPassword();
		String service = sm.getService();
	
		try {
			String sql = "insert into serviceman(ServiceID,fname,lname,email,password,service) values(?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, ServiceID);
			pst.setString(2, fname);
			pst.setString(3, lname);
			pst.setString(4, email);
			pst.setString(5, password);
			pst.setString(6, service);
			pst.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Customer getCustomerData(int id)
	{
		Customer c =null;
		Connection conn = ConnectionSetup.createConnection();
	
		try {
			String sql = "select * from customer where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				c = new Customer();
				c.setId(rs.getInt(1));
				c.setFname(rs.getString(2));
				c.setLname(rs.getString(3));
				c.setEmail(rs.getString(4));
				c.setPassword(rs.getString(5));
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	
	public static ServiceMan getServiceManData(int id)
	{
		ServiceMan s =null;
		Connection conn = ConnectionSetup.createConnection();
	
		try {
			String sql = "select * from serviceman where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				s = new ServiceMan();
				s.setId(rs.getInt(1));
				s.setServiceID(rs.getString(2));
				s.setFname(rs.getString(3));
				s.setLname(rs.getString(4));
				s.setEmail(rs.getString(5));
				s.setPassword(rs.getString(6));
				s.setService(rs.getString(7));
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
	public static void updateCustomer(Customer c)
	{
		Connection conn = ConnectionSetup.createConnection();
		try {
			String sql = "update customer set fname=?,lname=?,email=?,password=? where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, c.getFname());
			pst.setString(2, c.getLname());
			pst.setString(3, c.getEmail());
			pst.setString(4, c.getPassword());
			pst.setInt(5, c.getId());
			pst.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void updateServiceMan(ServiceMan sm)
	{
		Connection conn = ConnectionSetup.createConnection();
		try {
			String sql = "update serviceman set serviceID=?,fname=?,lname=?,email=?,password=?,service=? where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, sm.getServiceID());
			pst.setString(2, sm.getFname());
			pst.setString(3, sm.getLname());
			pst.setString(4, sm.getEmail());
			pst.setString(5, sm.getPassword());
			pst.setString(6, sm.getService());
			pst.setInt(7, sm.getId());
			pst.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void deleteCustomer(int id)
	{
		Connection conn = ConnectionSetup.createConnection();
		
		try {
			String sql = "delete from customer where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void deleteServiceMan(int id)
	{
		Connection conn = ConnectionSetup.createConnection();
		
		try {
			String sql = "delete from serviceman where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void deletePendingService(int id)
	{
		Connection conn = ConnectionSetup.createConnection();
		
		try {
			String sql = "delete from pending where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void insertApprovedService(pending p)
	{
		try {
			
			Connection conn = ConnectionSetup.createConnection();
			String sql = "insert into approved(cid,sid,cfname,cemail,sfname,semail,ServiceID,service,clname,slname) values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			System.out.println(p.getCid());
			System.out.println(p.getSid());
			System.out.println(p.getCfname());
			System.out.println(p.getCemail());
			System.out.println(p.getSfname());
			System.out.println(p.getSemail());
			System.out.println(p.getServiceID());
			System.out.println(p.getService());
			System.out.println(p.getSlname());
			System.out.println(p.getClname());
			
			pst.setInt(1, p.getCid());
			pst.setInt(2, p.getSid());
			pst.setString(3, p.getCfname());
			pst.setString(4, p.getCemail());
			pst.setString(5, p.getSfname());
			pst.setString(6, p.getSemail());
			pst.setString(7, p.getServiceID());
			pst.setString(8, p.getService());
			pst.setString(9, p.getClname());
			pst.setString(10, p.getSlname());
			pst.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static List<pending> showpendinglist() 
	{
		pending p = null;
		List<pending> list = new ArrayList<pending>();
		try {
			Connection conn = ConnectionSetup.createConnection();
			String sql ="select * from pending";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				p = new pending();
				p.setId(rs.getInt(1));
				p.setCid(rs.getInt(2));
				p.setSid(rs.getInt(3));
				p.setCfname(rs.getString(4));
				p.setCemail(rs.getString(5));
				p.setSfname(rs.getString(6));
				p.setSemail(rs.getString(7));
				p.setServiceID(rs.getString(8));
				p.setService(rs.getString(9));
				p.setClname(rs.getString(11));
				p.setSlname(rs.getString(12));
				list.add(p);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static List<approved> showapprovedlist() 
	{
		approved p = null;
		List<approved> list = new ArrayList<approved>();
		try {
			Connection conn = ConnectionSetup.createConnection();
			String sql ="select * from approved";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				p = new approved();
				p.setId(rs.getInt(1));
				p.setCid(rs.getInt(2));
				p.setSid(rs.getInt(3));
				p.setCfname(rs.getString(4));
				p.setCemail(rs.getString(5));
				p.setSfname(rs.getString(6));
				p.setSemail(rs.getString(7));
				p.setServiceID(rs.getString(8));
				p.setService(rs.getString(9));
				p.setClname(rs.getString(10));
				p.setSlname(rs.getString(11));
				list.add(p);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static void deleteApprovedService(int id)
	{
		Connection conn = ConnectionSetup.createConnection();
		
		try {
			String sql = "delete from approved where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void insertPendingService(approved p)
	{
		try {
			
			Connection conn = ConnectionSetup.createConnection();
			String sql = "insert into pending(cid,sid,cfname,cemail,sfname,semail,ServiceID,service,clname,slname) values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			System.out.println(p.getCid());
			System.out.println(p.getSid());
			System.out.println(p.getCfname());
			System.out.println(p.getCemail());
			System.out.println(p.getSfname());
			System.out.println(p.getSemail());
			System.out.println(p.getServiceID());
			System.out.println(p.getService());
			System.out.println(p.getSlname());
			System.out.println(p.getClname());
			
			pst.setInt(1, p.getCid());
			pst.setInt(2, p.getSid());
			pst.setString(3, p.getCfname());
			pst.setString(4, p.getCemail());
			pst.setString(5, p.getSfname());
			pst.setString(6, p.getSemail());
			pst.setString(7, p.getServiceID());
			pst.setString(8, p.getService());
			pst.setString(9, p.getClname());
			pst.setString(10, p.getSlname());
			pst.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
