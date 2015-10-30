package sw_engineering.project01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection getConnection() {
		Connection con = null;		
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			// forName : 예외처리
			String url="jdbc:mysql://localhost:3306/student_info";
			String userName="root";
			String password="1234";
			con = DriverManager.getConnection(url, userName, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("DB 연결 성공");
		return con;
	}

	public static void main(String[] args) {
		getConnection();
	}
}
