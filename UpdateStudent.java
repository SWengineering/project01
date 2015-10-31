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

			System.out.println("*** Student ���̺� �л� ���� �����ϱ� ***");
			
			System.out.print("�й� �Է� : ");
			studentId = bufferedReader.readLine();
			System.out.print("����ó �Է� : ");
			phone = bufferedReader.readLine();
			
			statement.setString(1, phone);
			statement.setString(2, studentId);
			
			result = statement.executeUpdate();
			
			System.out.println("�л� ���� ����");
			
		} catch(Exception e) {
			System.out.println("�л� ���� ����");
		}
	}

}
