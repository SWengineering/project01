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
			System.out.println("*** Student 테이블에 학생 추가하기 ***");
			System.out.print("학번 입력 : ");
			studentId = bufferedReader.readLine();
			System.out.print("이름 입력 : ");
			name = bufferedReader.readLine();
			System.out.print("학과 입력 : ");
			department = bufferedReader.readLine();
			System.out.print("연락처 입력 : ");
			phone = bufferedReader.readLine();
			
			sql += "('" + studentId + "', '" + name + "', '" + department + "', '" + phone + "')";
			System.out.println(sql);
			
			statement.execute(sql);
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
