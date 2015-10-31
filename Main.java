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

		// �߰��� �κ�!!	
		if (DBConnection.connection != null)
			addStudent = new AddStudent(DBConnection.connection);

		do {
			System.out.println("======================");
			System.out.println(" 1. �л� �߰� ");
			System.out.println(" 2. �л� ���� ");
			System.out.println(" 3. �л� ���� ���� ");
			System.out.println(" 4. �л� ���� ���� ");
			System.out.println(" 5. ���� ");
			System.out.println("======================");
			System.out.print("��ȣ�� �����ϼ��� >> ");
			
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
				System.out.println("���α׷��� �����մϴ�.");
				return;
			}
		} while ((choice >= 1) && (choice <= 4));
		
		dbConnection.disconnectDatabase();
	}
}
