package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.data.model.Person;

public class PersonDAO_Retrieve {
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

	public List<Person> ListPerson() {
		List<Person> list = new ArrayList<Person>();
		try {
			Connection con = getConnection();
			Statement st = con.createStatement();
			ResultSet res = st.executeQuery("select *from Person");
			while (res.next()) {
				Person p = new Person(res.getInt(1), res.getString(2), res.getString(3), res.getString(4),
						res.getString(5), res.getString(6));
				list.add(p);
			}
			res.close();
		}

		catch (Exception e) {
			System.out.println(e);

		}
		return list;

	}
}
