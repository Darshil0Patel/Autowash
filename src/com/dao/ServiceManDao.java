package com.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.Bean.ServiceMan;
import com.util.ConnectionSetup;


public class ServiceManDao {
	
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
	
	public static ServiceMan loginServiceMan(ServiceMan sm)
	{
		ServiceMan s1 = null;
		Connection conn = ConnectionSetup.createConnection();
		String ServiceID = sm.getServiceID();
		String password = sm.getPassword();
		try {
			String sql = "select * from serviceman where ServiceID=? and password=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, ServiceID);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				s1 = new ServiceMan();
				s1.setId(rs.getInt(1));
				s1.setServiceID(rs.getString(2));
				s1.setFname(rs.getString(3));
				s1.setLname(rs.getString(4));
				s1.setEmail(rs.getString(5));
				s1.setPassword(rs.getString(6));
				s1.setService(rs.getString(7));
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return s1;
	}
	
	public static void updateServiceMan(ServiceMan sm)
	{
		Connection conn = ConnectionSetup.createConnection();
		int id = sm.getId();
		String ServiceID = sm.getServiceID();
		String fname = sm.getFname();
		String lname = sm.getLname();
		String email = sm.getEmail();
		String password = sm.getPassword();
		String service = sm.getService();
		try {
			String sql = "update serviceman set ServiceID=?,fname=?,lname=?,email=?,password=?,service=? where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, ServiceID);
			pst.setString(2, fname);
			pst.setString(3, lname);
			pst.setString(4, email);
			pst.setString(5, password);
			pst.setString(6, service);
			pst.setInt(7, id);
			pst.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}















