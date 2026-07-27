package AcePlus;
import java.util.Scanner;
public class MyAge {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int currentYear = 2026;
		
		System.out.print("Enter your birth_year : ");
		int year = scanner.nextInt();
		
		int age = currentYear - year;
		System.out.println("You are " + age + " years old.");
		scanner.close();

	}

}
