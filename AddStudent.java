package sw_engineering.project01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddStudent {
	PreparedStatement statement = null;
	String studentId;
	String name;
	String department;
	String phone;
	
	public AddStudent(Connection connection) {
		if( getInputFromUser() ) {
			String sql = "Insert Into student (id, name, department, phone) Values (?,?,?,?)";
			
			try {
				statement = connection.prepareStatement(sql);
				
				statement.setString(1, studentId);
				statement.setString(2, name);
				statement.setString(3, department);
				statement.setString(4, phone);
				
				statement.executeUpdate();
				System.out.println("학생 추가 성공");
				
			} catch(Exception e) {
				System.out.println("학생 추가 실패");
			}
		}
	}

	public boolean getInputFromUser() {
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("*** Student 테이블에 학생 추가하기 ***");
			
			System.out.print("학번 입력 : ");
			studentId = bufferedReader.readLine();
			System.out.print("이름 입력 : ");
			name = bufferedReader.readLine();
			System.out.print("학과 입력 : ");
			department = bufferedReader.readLine();
			System.out.print("연락처 입력 : ");
			phone = bufferedReader.readLine();
			
			return true;
		} catch(Exception e) {
			System.out.println("사용자 입력 실패");
		}
		
		return false;
	}
}
