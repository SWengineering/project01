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
			System.out.print("������ ������ �л��� �й�: ");
			studentId = bufferedReader.readLine();
			
			statement.setString(1, studentId);
			result = statement.executeQuery();
			System.out.println("�й�\t�̸�\t�а�\t\t�ڵ��� ��ȣ");
			
			if (result.next()) {
				String name = result.getString("name");
				String department = result.getString("department");
				String phone = result.getString("phone");
				System.out.println(studentId+"\t"+name+"\t"+department+"\t\t"+phone);
			}
			else
				System.out.println("�ش� �й��� ���� �ѻ��� �����ϴ�!");
		} catch (Exception e) {
			System.out.println("");
		}
	}
}
