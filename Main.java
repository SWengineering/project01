package sw_engineering.project01;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	static DBConnection dbConnection = null;
	static AddStudent addStudent = null;
<<<<<<< HEAD
	static UpdateStudent updateStudent = null;
=======
>>>>>>> 9cc385cc5ec4dc477310d34af267875da3b1ca87
	static ViewStudent viewStudent = null;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		dbConnection = new DBConnection();
<<<<<<< HEAD
		int choice = 1;
		
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
		
=======
		int choice;
		do {
			System.out.println("======================");
			System.out.println(" 1. 학생 추가 ");
			System.out.println(" 2. 학생 삭제 ");
			System.out.println(" 3. 학생 정보 수정 ");
			System.out.println(" 4. 학생 정보 열람 ");
			System.out.println("======================");
			System.out.print("번호를 선택하세요 >> ");
			Scanner scan = new Scanner(System.in);
			choice = scan.nextInt();
		
>>>>>>> 9cc385cc5ec4dc477310d34af267875da3b1ca87
			switch(choice) {
			case 1:
				addStudent = new AddStudent(DBConnection.connection);
				break;
<<<<<<< HEAD
			case 2:
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
		
=======
			case 4:
				viewStudent = new ViewStudent(DBConnection.connection);
				break;
			}
		} while (choice < 1 || choice > 4);
		dbConnection.disconnectDatabase();
>>>>>>> 9cc385cc5ec4dc477310d34af267875da3b1ca87
	}
}
