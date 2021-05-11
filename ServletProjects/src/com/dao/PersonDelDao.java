package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.data.model.Person;

public class PersonDelDao {
	static Connection getConnection() {
		 Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java200", "root", "root");
			System.out.println("Connected" + con );
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
	public boolean delPerson(int num) {
		boolean b=false;
		try {
			Connection con=getConnection();
			PreparedStatement pst=con.prepareStatement("delete from Person where pid=?");
			pst.setInt(1, num);
			int res=pst.executeUpdate();
			if(res>0) {
				b=true;
			}
		}
		catch (Exception e) { 
			System.out.println(e);
			
		}
		return b;
		
	}
	public boolean updatePerson(Person person) {
		// TODO Auto-generated method stub
		return false;
	}
}
