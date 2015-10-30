package sw_engineering.project01;

public class Main {
	static DBConnection dbConnection = null;
	static AddStudent addStudent = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dbConnection = new DBConnection();
		
		// 추가할 부분!!	
		addStudent = new AddStudent(DBConnection.connection);
		
		
		dbConnection.disconnectDatabase();
	}

}
