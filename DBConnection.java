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
			System.out.println("JDBC 드라이버 로드 성공!");
			
			return true;
		} catch (java.lang.ClassNotFoundException e) {
			System.err.println("JDBC 드라이버 로드 실패!");
		}
		
		return false;
	}
	
	public static void connectDatabase() {
		
		try {
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("\n데이터베이스 연결 성공: "+ url);
			
		} catch (SQLException ex) {
			System.out.println("\n데이터베이스 연결 실패: "+ url);
		}
	}
	
	public void disconnectDatabase() {
		try {			
			if(connection != null)
				connection.close();
			
			System.out.println("\n데이터베이스 연결 해제");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
