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
		System.out.print("정보를 열람할 학번: ");
		int studentId = scan.nextInt();
		String sql = "SELECT name, department, phone FROM student where id=?";
		System.out.println("학번\t이름\t학과\t\t핸드폰 번호");
		
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
				System.out.println("해당 학번을 가진 한생이 없습니다!");

		} catch (SQLException ex) {
			System.out.println("\n데이터베이스 연결 실패: ");
		}
	}
}
