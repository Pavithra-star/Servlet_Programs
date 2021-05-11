package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.data.model.Person;

public class PersonDao {
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

	public static boolean addPerson(Person person) {
		boolean b = false;
		try {
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("insert into Person(ename,contactno,email,gender,address)values(?,?,?,?,?)");
			pst.setString(1, person.getEname());
			pst.setString(2, person.getContactno());
			pst.setString(3, person.getEmail());
			pst.setString(4, person.getGender());
			pst.setString(5, person.getAddress());
			int res = pst.executeUpdate();
			
			if (res > 0) {
				b = true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return b;
	}
}
