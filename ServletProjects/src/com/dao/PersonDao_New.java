package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class PersonDao_New {
static Connection getConnection() {
	Connection con = null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java200", "root", "root");
		System.out.println("Connected" + con);
	} catch (Exception e) {
		System.out.println(e);
	}
	return con;
}

public boolean validate(String uname, String upass) {
	boolean b = false;
	try {
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("select *from Person where ename=? and contactno=?");
		pst.setString(1, uname);
		pst.setString(2, upass);
		ResultSet res = pst.executeQuery();
		if (res.next()) {
			b = true;
		}
	} catch (Exception e) {
		System.out.println(e);
	}
	return false;
}
}
