package sw_engineering.project01;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	static DBConnection dbConnection = null;
	static AddStudent addStudent = null;
	static ViewStudent viewStudent = null;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		dbConnection = new DBConnection();
		int choice;
		do {
			System.out.println("======================");
			System.out.println(" 1. �л� �߰� ");
			System.out.println(" 2. �л� ���� ");
			System.out.println(" 3. �л� ���� ���� ");
			System.out.println(" 4. �л� ���� ���� ");
			System.out.println("======================");
			System.out.print("��ȣ�� �����ϼ��� >> ");
			Scanner scan = new Scanner(System.in);
			choice = scan.nextInt();
		
			switch(choice) {
			case 1:
				addStudent = new AddStudent(DBConnection.connection);
				break;
			case 4:
				viewStudent = new ViewStudent(DBConnection.connection);
				break;
			}
		} while (choice < 1 || choice > 4);
		dbConnection.disconnectDatabase();
	}
}
