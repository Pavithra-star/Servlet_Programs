package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.data.model.Person;

public class PersonDaoUpdate {
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

	}public static boolean updatePerson(Person person) {
		boolean b = false;
		try {
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("update Person set ename =?,email=?,gender=?,address=? where pid=?");
			pst.setString(1, person.getEname());
			pst.setString(2, person.getContactno());
			pst.setString(3, person.getEmail());
			pst.setString(4, person.getGender());
			pst.setString(5, person.getAddress());
			pst.setInt(6,person.getPid());
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

