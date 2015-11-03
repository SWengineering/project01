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
				System.out.println("�л� �߰� ����");
				
			} catch(Exception e) {
				System.out.println("�л� �߰� ����");
			}
		}
	}

	public boolean getInputFromUser() {
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("*** Student ���̺� �л� �߰��ϱ� ***");
			
			System.out.print("�й� �Է� : ");
			studentId = bufferedReader.readLine();
			System.out.print("�̸� �Է� : ");
			name = bufferedReader.readLine();
			System.out.print("�а� �Է� : ");
			department = bufferedReader.readLine();
			System.out.print("����ó �Է� : ");
			phone = bufferedReader.readLine();
			
			return true;
		} catch(Exception e) {
			System.out.println("����� �Է� ����");
		}
		
		return false;
	}
}
