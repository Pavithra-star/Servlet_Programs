package com.emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class data {
	int id;
	String name;
	int marks;

	public data() {
		System.out.println("default ");
	}

	public data(int id, String name, int marks) {
		this.id = id;
		this.name = name;
		this.marks = marks;
	}
}

class Operations {
	Connection getconnection() {
		Connection con = null;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java200", "root", "root");
			System.out.println("Connected " + con);
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	void menu() {
		String m = "Menu driven Application\n";
		m += "1.Add statement\n";
		m += "2.delete data\n";
		m += "3.update data\n";
		m += "4.List data\n";
		m += "5.Exit\n";
		m += "Select any option?";
		System.out.println(m);
	}

	boolean addData(data data1) {
		boolean b = false;
		try {
			Connection con = getconnection();
			PreparedStatement pst = con.prepareStatement("insert into data values(?,?,?)");
			pst.setInt(1, data1.id);
			pst.setString(2, data1.name);
			pst.setInt(3, data1.marks);
			int res = pst.executeUpdate();
			if (res > 0) {
				b = true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return b;

	}

	boolean deletedata(int num) {
		boolean b = false;
		try {
			Connection con = getconnection();
			PreparedStatement pst = con.prepareStatement("delete from data where id=?");
			pst.setInt(1, num);
			int res = pst.executeUpdate();
			if (res > 0) {
				b = true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return b;
	}

	boolean updatedata(data data2) {
		boolean b = false;
		try {
			Connection con = getconnection();
			PreparedStatement pst = con.prepareStatement("update  data set name=?" + ",marks = ? where id=?");
			pst.setInt(1, data2.id);
			pst.setString(2, data2.name);
			pst.setInt(3, data2.marks);
			int res = pst.executeUpdate();
			if (res > 0) {
				b = true;
			} 
		} catch (Exception e) {
			System.out.println(e);
		}
		return b;
	}

	List<data> listdata() {
		List<data> list = new ArrayList<data>();
		try {
			Connection con = getconnection();
			Statement st = con.createStatement();
			ResultSet res = st.executeQuery("select *from data");
			while (res.next()) {
				data d = new data(res.getInt(1), res.getString(2), res.getInt(3));
				list.add(d);
			}
			res.close();
			st.close();
		} catch (Exception e) {
			System.out.println(e);// TODO: handle exception
		}
		return list;
	}

	public void accept() {
		System.out.println("Enter yor num,name,marks ?");
	}

}

public class Menu_DataBase {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Operations obj = new Operations();
		for (;;) {
			obj.menu();
			int choice = sc.nextInt();
			switch (choice) {

			case 1:
				obj.accept();
				obj.addData(new data(sc.nextInt(), sc.next(), sc.nextInt()));
				break;
			case 2:
				System.out.println("Enter your num to delete?");
				obj.deletedata(sc.nextInt());
				break;
			case 3:
				obj.accept();
				obj.updatedata(new data(sc.nextInt(), sc.next(), sc.nextInt()));
				break;
			case 4:
				System.out.println("Data info");
				List<data> list = obj.listdata();
				list.forEach(x -> System.out.println(x.id + " " + x.name + " " + x.marks));
				break;
			case 5:
				System.exit(0);
			default:
				System.out.println("invalid option");
				break;
			}// closing switch

		}//closing for loop

	}//closing main
}
