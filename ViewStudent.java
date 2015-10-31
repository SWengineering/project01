package sw_engineering.project01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ViewStudent {
	PreparedStatement statement = null; 
	ResultSet result = null;
	String studentId; 
	String name;
	String department; 
	String phone;
	

	public ViewStudent(Connection connection) {
		viewStudentInfo(connection);
	}
	
	public void viewStudentInfo(Connection connection) {
		String sql = "SELECT name, department, phone FROM student where id=?";
		
		try {
			statement = connection.prepareStatement(sql);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
<<<<<<< HEAD
			
=======
>>>>>>> 9cc385cc5ec4dc477310d34af267875da3b1ca87
			System.out.print("정보를 열람할 학생의 학번: ");
			studentId = bufferedReader.readLine();
			
			statement.setString(1, studentId);
			result = statement.executeQuery();
			System.out.println("학번\t이름\t학과\t\t핸드폰 번호");
			
			if (result.next()) {
				String name = result.getString("name");
				String department = result.getString("department");
				String phone = result.getString("phone");
				System.out.println(studentId+"\t"+name+"\t"+department+"\t\t"+phone);
			}
			else
				System.out.println("해당 학번을 가진 한생이 없습니다!");
		} catch (Exception e) {
			System.out.println("");
		}
	}
}
