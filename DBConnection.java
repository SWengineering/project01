package sw_engineering.project01;

import java.sql.*;

public class DBConnection {
	static String url = "jdbc:mysql://localhost:3306/student_info";
	static String user = "root";
	static String password = "1234";
	
	public static Connection connection = null;
	public static Statement statement = null;
	public static ResultSet result = null;

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
			
			statement = connection.createStatement();
			
			//test
			//-------------------------------------------------------------
			String sql = "Select * From student_info.student";
			result = statement.executeQuery(sql);
			
			while (result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				String department = result.getString("department");
				String phone = result.getString("phone");
				System.out.println(id+"\t"+name+"\t"+department+"\t"+phone);
			}
			//-------------------------------------------------------------
			
		} catch (SQLException ex) {
			System.out.println("\n�����ͺ��̽� ���� ����: "+ url);
		}
	}
	
	public void disconnectDatabase() {
		try {
			if(result != null)	
				result.close();
			
			if(statement != null)	
				statement.close();
			
			if(connection != null)
				connection.close();
			
			System.out.println("\n�����ͺ��̽� ���� ����");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
