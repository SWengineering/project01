package sw_engineering.project01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DeleteStudent {
	PreparedStatement statement = null; 
	String studentId;

	public DeleteStudent(Connection connection) {
		deleteStudentInfo(connection);
	}
	
	public void deleteStudentInfo(Connection connection) {
		String sql = "DELETE FROM student where id=?";
		
		try {
			statement = connection.prepareStatement(sql);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("������ �л��� �й�: ");
			studentId = bufferedReader.readLine();
			statement.setString(1, studentId);
			statement.executeUpdate();
			
			System.out.println("�й��� "+studentId+"�� �л��� ������ �����߽��ϴ�");
			
		} catch (Exception e) {
			System.out.println("���� �����Ͽ����ϴ�");
		}
	}
}