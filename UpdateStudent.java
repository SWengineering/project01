package sw_engineering.project01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UpdateStudent {
	
	PreparedStatement statement = null;
	int result;
	String studentId;
	String name;
	String department;
	String phone;
	
	public UpdateStudent(Connection connection) {

		String sql = "Update STUDENT SET phone=? where id=?";
		
		try {
			statement = connection.prepareStatement(sql);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("*** Student 테이블에 학생 정보 갱신하기 ***");
			
			System.out.print("학번 입력 : ");
			studentId = bufferedReader.readLine();
			System.out.print("연락처 입력 : ");
			phone = bufferedReader.readLine();
			
			statement.setString(1, phone);
			statement.setString(2, studentId);
			
			result = statement.executeUpdate();
			
			System.out.println("학생 갱신 성공");
			
		} catch(Exception e) {
			System.out.println("학생 갱신 실패");
		}
	}

}
