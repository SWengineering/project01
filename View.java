package sw_engineering.project01;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.mysql.jdbc.PreparedStatement;

public class View {
	public static void main(String[] args) throws IOException {
		Connection con = DBConnection.getConnection();
		ResultSet result = null;
		PreparedStatement pstmt = null;

		Scanner scan = new Scanner(System.in);
		System.out.print("������ ������ �й�: ");
		int studentId = scan.nextInt();
		String sql = "SELECT name, department, phone FROM student where id=?";
		System.out.println("�й�\t�̸�\t�а�\t\t�ڵ��� ��ȣ");
		
		try {			
			pstmt = (PreparedStatement)con.prepareStatement(sql);
			pstmt.setInt(1,  studentId);
			result = pstmt.executeQuery();
			
			if (result.next()) {
				String name = result.getString("name");
				String department = result.getString("department");
				String phone = result.getString("phone");
				System.out.println(studentId+"\t"+name+"\t"+department+"\t\t"+phone);
			}
			else
				System.out.println("�ش� �й��� ���� �ѻ��� �����ϴ�!");

		} catch (SQLException ex) {
			System.out.println("\n�����ͺ��̽� ���� ����: ");
		}
	}
}
