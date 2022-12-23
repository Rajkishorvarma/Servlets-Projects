package com.durgasoft.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.durgasoft.beans.Student;

public class StudentService {
	Connection con;
	Statement st;
	ResultSet rs;
	public StudentService() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rajdb","root","root");
			st = con.createStatement();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public  Student getStudent(String sid){
		Student std=null;
		try {
			rs = st.executeQuery("select * from student where SID='"+sid+"'");
			boolean b = rs.next();
			if (b==true) {
				std = new Student();
				std.setSid(rs.getString("SID"));
				std.setSname(rs.getString("SNAME"));
				std.setSaddr(rs.getString("SADDR"));
			}else {
				std= null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return std;
	}
	public String update(Student std) {
		String status = "";
		try {
			int rowCount = st.executeUpdate("update student set SNAME = '"+std.getSname()+"', SADDR='"+std.getSaddr()+"' where SID='"+std.getSid()+"'");
			if (rowCount==1) {
				status="success";
			} else {
				status="failure";	
			}
		} catch (Exception e) {
			status= "failure";
			e.printStackTrace();
		}
		return status;
	}
}
