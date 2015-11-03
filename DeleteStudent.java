package sw_engineering.project01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteStudent {
	PreparedStatement statement = null; 
	String studentId;
	int result;

	public DeleteStudent(Connection connection) {
		if( getInputFromUser() ) {
			String sql = "DELETE FROM student where id=?";
			
			try {
				statement = connection.prepareStatement(sql);
				
				statement.setString(1, studentId);
				result = statement.executeUpdate();
				
				if (result==1)
					System.out.println("학번이 "+studentId+"인 학생의 정보를 삭제했습니다");
				else 
					System.out.println("해당 학생 정보가 없습니다");
				
			} catch (Exception e) {
				System.out.println("삭제 실패하였습니다");
			}
		}
	}
	
	public boolean getInputFromUser() {
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("삭제할 학생의 학번: ");
			studentId = bufferedReader.readLine();
			
			return true;
		} catch(Exception e) {
			System.out.println("사용자 입력 실패");
		}
		
		return false;
	}
}
