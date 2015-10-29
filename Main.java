package sw_engineering.project01;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
	static DBConnection dbConnection = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResultSet result = null;
		dbConnection = new DBConnection();
		
		// 추가할 부분!!
		try {			
			
			//test
			//-------------------------------------------------------------
			String sql = "Select * From student_info.student";
			result = DBConnection.statement.executeQuery(sql);
			
			while (result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				String department = result.getString("department");
				String phone = result.getString("phone");
				System.out.println(id+"\t"+name+"\t"+department+"\t"+phone);
			}
			//-------------------------------------------------------------
			
		} catch (SQLException ex) {
			System.out.println("\n데이터베이스 연결 실패: ");
		}
		
		
		dbConnection.disconnectDatabase();
	}

}
