package sw_engineering.project01;

import java.sql.*;

public class DBConnection {
	final static String url = "jdbc:mysql://localhost:3306/student_info";
	final static String user = "root";
	final static String password = "1234";
	
	public static Connection connection = null;

	public DBConnection() {
		if( loadDriver() )
			connectDatabase();
	}
	
	public static boolean loadDriver() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("JDBC ����̹� �ε� ����!");
			
			return true;
		} catch (java.lang.ClassNotFoundException e) {
			System.err.println("JDBC ����̹� �ε� ����!");
		}
		
		return false;
	}
	
	public static void connectDatabase() {
		
		try {
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("\n�����ͺ��̽� ���� ����: "+ url);
			
		} catch (SQLException ex) {
			System.out.println("\n�����ͺ��̽� ���� ����: "+ url);
		}
	}
	
	public void disconnectDatabase() {
		try {			
			if(connection != null)
				connection.close();
			
			System.out.println("\n�����ͺ��̽� ���� ����");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
