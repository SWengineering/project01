import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DB {
	public static Connection getConnection() {
		Connection con = null;		
		try {
			Class.forName("org.gjt.mm.mysql.Driver");	// 1. JDBC Driver 로딩
			// forName : 예외처리
			String url="jdbc:mysql://localhost:3306/yuhan1";
			String userName="root";
			String password="1234";
			con = DriverManager.getConnection(url, userName, password);		// 2. 연결객체	
			// 3. 문장객체	Statement, PreparedStatement
			// 4. SQL실행	5. 연결,문장 rs 닫기
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("DB 연결 성공");
		return con;
	}//getConnection

	public static void main(String[] args) {
		getConnection();
	}//main
}//DB
