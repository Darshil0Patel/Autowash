package com.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Bean.Customer;
import com.Bean.ServiceMan;
import com.Bean.approved;
import com.Bean.pending;
import com.util.ConnectionSetup;


public class CustomerDao2 {
	
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
	
	public static Customer loginCustomer(Customer c)
	{
		Customer cs = null;
		Connection conn = ConnectionSetup.createConnection();
		String email = c.getEmail();
		String password = c.getPassword();
		try {
			String sql = "select * from customer where email = ? and password = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				cs = new Customer();
				cs.setId(rs.getInt(1));
				cs.setFname(rs.getString(2));
				cs.setLname(rs.getString(3));
				cs.setEmail(rs.getString(4));
				cs.setPassword(rs.getString(5));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return cs;
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
	
	public static List<ServiceMan> showExteriorServiceman() 
	{
		ServiceMan sm = null;
		List<ServiceMan> list = new ArrayList<ServiceMan>();
		try {
			Connection conn = ConnectionSetup.createConnection();
			String sql ="select * from serviceman where service=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, "Exterior Washing");
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				sm = new ServiceMan();
				sm.setId(rs.getInt(1));
				sm.setServiceID(rs.getString(2));
				sm.setFname(rs.getString(3));
				sm.setLname(rs.getString(4));
				sm.setEmail(rs.getString(5));
				sm.setPassword(rs.getString(6));
				sm.setService(rs.getString(7));
				list.add(sm);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static List<ServiceMan> showInteriorServiceman() 
	{
		ServiceMan sm = null;
		List<ServiceMan> list = new ArrayList<ServiceMan>();
		try {
			Connection conn = ConnectionSetup.createConnection();
			String sql ="select * from serviceman where service=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, "Interior Washing");
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				sm = new ServiceMan();
				sm.setId(rs.getInt(1));
				sm.setServiceID(rs.getString(2));
				sm.setFname(rs.getString(3));
				sm.setLname(rs.getString(4));
				sm.setEmail(rs.getString(5));
				sm.setPassword(rs.getString(6));
				sm.setService(rs.getString(7));
				list.add(sm);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static List<ServiceMan> showVacuumServiceman() 
	{
		ServiceMan sm = null;
		List<ServiceMan> list = new ArrayList<ServiceMan>();
		try {
			Connection conn = ConnectionSetup.createConnection();
			String sql ="select * from serviceman where service=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, "Vacuum Cleaning");
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				sm = new ServiceMan();
				sm.setId(rs.getInt(1));
				sm.setServiceID(rs.getString(2));
				sm.setFname(rs.getString(3));
				sm.setLname(rs.getString(4));
				sm.setEmail(rs.getString(5));
				sm.setPassword(rs.getString(6));
				sm.setService(rs.getString(7));
				list.add(sm);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static List<ServiceMan> showSeatswashingServiceman() 
	{
		ServiceMan sm = null;
		List<ServiceMan> list = new ArrayList<ServiceMan>();
		try {
			Connection conn = ConnectionSetup.createConnection();
			String sql ="select * from serviceman where service=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, "Seats Washing");
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				sm = new ServiceMan();
				sm.setId(rs.getInt(1));
				sm.setServiceID(rs.getString(2));
				sm.setFname(rs.getString(3));
				sm.setLname(rs.getString(4));
				sm.setEmail(rs.getString(5));
				sm.setPassword(rs.getString(6));
				sm.setService(rs.getString(7));
				list.add(sm);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static List<ServiceMan> showWindowwipingServiceman() 
	{
		ServiceMan sm = null;
		List<ServiceMan> list = new ArrayList<ServiceMan>();
		try {
			Connection conn = ConnectionSetup.createConnection();
			String sql ="select * from serviceman where service=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, "Window Wiping");
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				sm = new ServiceMan();
				sm.setId(rs.getInt(1));
				sm.setServiceID(rs.getString(2));
				sm.setFname(rs.getString(3));
				sm.setLname(rs.getString(4));
				sm.setEmail(rs.getString(5));
				sm.setPassword(rs.getString(6));
				sm.setService(rs.getString(7));
				list.add(sm);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static List<ServiceMan> showWetcleaningServiceman() 
	{
		ServiceMan sm = null;
		List<ServiceMan> list = new ArrayList<ServiceMan>();
		try {
			Connection conn = ConnectionSetup.createConnection();
			String sql ="select * from serviceman where service=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, "Wet Cleaning");
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				sm = new ServiceMan();
				sm.setId(rs.getInt(1));
				sm.setServiceID(rs.getString(2));
				sm.setFname(rs.getString(3));
				sm.setLname(rs.getString(4));
				sm.setEmail(rs.getString(5));
				sm.setPassword(rs.getString(6));
				sm.setService(rs.getString(7));
				list.add(sm);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static List<ServiceMan> showOilchangingServiceman() 
	{
		ServiceMan sm = null;
		List<ServiceMan> list = new ArrayList<ServiceMan>();
		try {
			Connection conn = ConnectionSetup.createConnection();
			String sql ="select * from serviceman where service=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, "Oil Changing");
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				sm = new ServiceMan();
				sm.setId(rs.getInt(1));
				sm.setServiceID(rs.getString(2));
				sm.setFname(rs.getString(3));
				sm.setLname(rs.getString(4));
				sm.setEmail(rs.getString(5));
				sm.setPassword(rs.getString(6));
				sm.setService(rs.getString(7));
				list.add(sm);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static List<ServiceMan> showBrakereparingServiceman() 
	{
		ServiceMan sm = null;
		List<ServiceMan> list = new ArrayList<ServiceMan>();
		try {
			Connection conn = ConnectionSetup.createConnection();
			String sql ="select * from serviceman where service=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, "Brake Reparing");
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				sm = new ServiceMan();
				sm.setId(rs.getInt(1));
				sm.setServiceID(rs.getString(2));
				sm.setFname(rs.getString(3));
				sm.setLname(rs.getString(4));
				sm.setEmail(rs.getString(5));
				sm.setPassword(rs.getString(6));
				sm.setService(rs.getString(7));
				list.add(sm);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static void insertpending(pending p)
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
	
	public static List<pending> showpendinglist(int cid) 
	{
		pending p = null;
		List<pending> list = new ArrayList<pending>();
		try {
			Connection conn = ConnectionSetup.createConnection();
			String sql ="select * from pending where cid=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, cid);
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
	
	public static List<approved> showapprovedlist(int cid) 
	{
		approved a = null;
		List<approved> list = new ArrayList<approved>();
		try {
			Connection conn = ConnectionSetup.createConnection();
			String sql ="select * from approved where cid=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, cid);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				a = new approved();
				a.setId(rs.getInt(1));
				a.setCid(rs.getInt(2));
				a.setSid(rs.getInt(3));
				a.setCfname(rs.getString(4));
				a.setCemail(rs.getString(5));
				a.setSfname(rs.getString(6));
				a.setSemail(rs.getString(7));
				a.setServiceID(rs.getString(8));
				a.setService(rs.getString(9));
				a.setClname(rs.getString(10));
				a.setSlname(rs.getString(11));
				list.add(a);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}
}
