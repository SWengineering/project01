import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DB {
	public static Connection getConnection() {
		Connection con = null;		
		try {
			Class.forName("org.gjt.mm.mysql.Driver");	// 1. JDBC Driver �ε�
			// forName : ����ó��
			String url="jdbc:mysql://localhost:3306/yuhan1";
			String userName="root";
			String password="1234";
			con = DriverManager.getConnection(url, userName, password);		// 2. ���ᰴü	
			// 3. ���尴ü	Statement, PreparedStatement
			// 4. SQL����	5. ����,���� rs �ݱ�
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("DB ���� ����");
		return con;
	}//getConnection

	public static void main(String[] args) {
		getConnection();
	}//main
}//DB
