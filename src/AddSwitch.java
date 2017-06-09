import java.util.Scanner;

public class AddSwitch {

	public static void main(String[] args){
		
		int choice;
		Scanner scan = new Scanner(System.in);
		ResumeAssignment assignment = new ResumeAssignment();
		System.out.println("please Enter a choice: ");
		System.out.println("1. For Insert");
		System.out.println("2. For Display");
		System.out.println("3. For Update");
		System.out.println("4. For Delete");
		
		choice = scan.nextInt();
		
		switch(choice){
		
		case 1:
			assignment.add();
			break;
		case 2:
			assignment.display();
			break;
		case 3:
			assignment.update();
			break;
		case 4:
			assignment.delete();
			break;
			default:
				System.out.println("Wrong choice! please choose number between 1 to 4");
		}
		
	}
}
