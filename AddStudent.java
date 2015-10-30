package sw_engineering.project01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Statement;

public class AddStudent {
	Statement statement = null;
	String studentId;
	String name;
	String department;
	String phone;
	
	public AddStudent(Statement statement) {
		this.statement = statement;
		insertStudent();
	}
	
	public void insertStudent() {
		String sql = "Insert Into student (id, name, department, phone) Values";
		
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
			
			sql += "('" + studentId + "', '" + name + "', '" + department + "', '" + phone + "')";
			System.out.println(sql);
			
			statement.execute(sql);
			System.out.println("�л� �߰� ����");
			
		} catch(Exception e) {
			System.out.println("�л� �߰� ����");
		}
	}
	/*
	String sql = "insert into albums values(?,?,?,?)";
	PreparedStatement stat=conn.prepareStatement(sql);
	stat.setString(1, vaname);
	stat.setString(2, vbname);
	stat.setString(3, vyear);
	stat.setString(4, vprice);
	stat.executeUpdate();
	*/
}
