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
					System.out.println("�й��� "+studentId+"�� �л��� ������ �����߽��ϴ�");
				else 
					System.out.println("�ش� �л� ������ �����ϴ�");
				
			} catch (Exception e) {
				System.out.println("���� �����Ͽ����ϴ�");
			}
		}
	}
	
	public boolean getInputFromUser() {
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("������ �л��� �й�: ");
			studentId = bufferedReader.readLine();
			
			return true;
		} catch(Exception e) {
			System.out.println("����� �Է� ����");
		}
		
		return false;
	}
}
