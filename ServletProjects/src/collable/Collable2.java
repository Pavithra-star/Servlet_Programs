package collable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class Collable2 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java200", "root", "root");
			System.out.println("Connected" + con);
			Scanner sc = new Scanner(System.in);
			System.out.println("Eneter two wmpno numbers?");
			CallableStatement cst = con.prepareCall("{? = CALL getAverage(?,?)}");
			cst.registerOutParameter(1, Types.FLOAT);
			cst.setInt(2, sc.nextInt());
			cst.setInt(3, sc.nextInt());
			cst.execute();
			float avgsalary = cst.getFloat(1);
			System.out.println("average  salary  of employee " + avgsalary);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}