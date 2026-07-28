package AcePlus;
import java.util.Scanner;
public class Hello {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter your name : ");
		String name = scanner.nextLine();
		
		System.out.print("Enter your birthday : ");
		String birthday = scanner.nextLine();
		
		System.out.println("Name - " + name);
		System.out.println("Birthday - " + birthday);
		scanner.close();
				
	}

}
