package collable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import com.sun.xml.internal.ws.org.objectweb.asm.Type;

public class CallableStatement_Program {
public static void main(String[] args) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java200", "root", "root");
		System.out.println("Connected" +con);
		Scanner sc=new Scanner(System.in); 
		System.out.println("Emp no ?");
		CallableStatement cst= con.prepareCall("{CALL getSal(?,?)}");
		cst.setInt(1, sc.nextInt());
		cst.registerOutParameter(2, Type.FLOAT);
		cst.execute();
		float salary = cst .getFloat(2);
		System.out.println("Yoyur salry is =" +salary);
	}
	catch (Exception e) {
	System.out.println(e);
	}
}
}
