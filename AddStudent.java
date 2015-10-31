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
		insertStudent(connection);
	}

	public void insertStudent(Connection connection) {
		String sql = "Insert Into student (id, name, department, phone) Values (?,?,?,?)";
		
		try {
			statement = connection.prepareStatement(sql);
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
			
			statement.setString(1, studentId);
			statement.setString(2, name);
			statement.setString(3, department);
			statement.setString(4, phone);
			//sql += "('" + studentId + "', '" + name + "', '" + department + "', '" + phone + "')";
			//System.out.println(sql);
			
			statement.executeUpdate();
			System.out.println("학생 추가 성공");
			
		} catch(Exception e) {
			System.out.println("학생 추가 실패");
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
