package AcePlus;
import java.util.Scanner;
public class MyIcon {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter a symbol : ");
		char symbol = scanner.nextLine().charAt(0);
		
		System.out.print("Enter a number : ");
		int number = scanner.nextInt();
		
		for(int i = 0; i<number ; i++)
		{
			System.out.print(symbol + " ");
		}
		scanner.close();
	}

}
