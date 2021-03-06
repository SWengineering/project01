package sw_engineering.project01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateStudent {
	PreparedStatement statement = null;
	int result;
	String studentId;
	String name;
	String department;
	String phone;
	
	public UpdateStudent(Connection connection) {
		if( getInputFromUser() ) {
			String sql = "Update STUDENT SET phone=? where id=?";
			
			try {
				statement = connection.prepareStatement(sql);
							
				statement.setString(1, phone);
				statement.setString(2, studentId);
				
				result = statement.executeUpdate();
				
				if (result==1)
					System.out.println("학생 갱신 성공");
				else 
					System.out.println("해당 학생 정보가 없습니다");
				
			} catch(Exception e) {
				System.out.println("학생 갱신 실패");
			}
		}
	}
	
	public boolean getInputFromUser() {
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("*** Student 테이블에 학생 정보 갱신하기 ***");
			
			System.out.print("학번 입력 : ");
			studentId = bufferedReader.readLine();
			System.out.print("연락처 입력 : ");
			phone = bufferedReader.readLine();
			
			return true;
		} catch(Exception e) {
			System.out.println("사용자 입력 실패");
		}
		
		return false;
	}

}
