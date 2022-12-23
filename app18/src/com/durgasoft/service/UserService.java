package com.durgasoft.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserService {
	Connection con;
	Statement st;
	ResultSet rs;
	String status="";
	public UserService() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rajdb","root","root");
			st=con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String checkLogin(String uname,String upwd) {
		try {
			rs= st.executeQuery("select * from regUser where UNAME ='"+uname+"' and UPWD = '"+upwd+"'");
			boolean b = rs.next();
			if(b==true) {
				status ="success";
			}else {
				status ="failure";
			}
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return status;
	}
	public String registration(String uname,String upwd,String uemail,String umobile) {
		try {
			rs=st.executeQuery("select * from regUser where UNAME = '"+uname+"' ");
			boolean b = rs.next();
			if(b==true) {
				status ="existed";
			}else {
				int rowCount = st.executeUpdate("insert into regUser values('"+uname+"','"+upwd+"','"+uemail+"','"+umobile+"')");
				if(rowCount == 1) {
					status = "success";
				}else {
					status = "failure";
				}
			}
			
		} catch (Exception e2) {
			status ="failure";
			e2.printStackTrace();
		}
		return status;
	}
}
