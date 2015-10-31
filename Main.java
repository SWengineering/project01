package sw_engineering.project01;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	static DBConnection dbConnection = null;
	static AddStudent addStudent = null;
	static DeleteStudent deleteStudent = null;
	static UpdateStudent updateStudent = null;
	static ViewStudent viewStudent = null;
	static int choice = 0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		dbConnection = new DBConnection();		

		// 추가할 부분!!	
		if (DBConnection.connection != null)
			addStudent = new AddStudent(DBConnection.connection);

		do {
			System.out.println("======================");
			System.out.println(" 1. 학생 추가 ");
			System.out.println(" 2. 학생 삭제 ");
			System.out.println(" 3. 학생 정보 수정 ");
			System.out.println(" 4. 학생 정보 열람 ");
			System.out.println(" 5. 종료 ");
			System.out.println("======================");
			System.out.print("번호를 선택하세요 >> ");
			
			Scanner scan = new Scanner(System.in);
			choice = scan.nextInt();

			switch(choice) {
			case 1:
				addStudent = new AddStudent(DBConnection.connection);
				break;
			case 2:
				deleteStudent = new DeleteStudent(DBConnection.connection);
				break;
			case 3:
				updateStudent = new UpdateStudent(DBConnection.connection);
				break;
			case 4:
				viewStudent = new ViewStudent(DBConnection.connection);
				break;
			case 5:
				dbConnection.disconnectDatabase();
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		} while ((choice >= 1) && (choice <= 4));
		
		dbConnection.disconnectDatabase();
	}
}
