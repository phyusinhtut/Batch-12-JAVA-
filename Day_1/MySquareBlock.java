import java.util.Scanner;
public class MySquareBlock {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a character : ");
        char userChar = scanner.nextLine().charAt(0);

        System.out.print("Enter number of lines to print : ");
        int lineNum = scanner.nextInt();

        for(int i = 0; i < lineNum ; i++)
        {
            for(int j = 0; j < lineNum ; j++)
            {
                System.out.print(userChar + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}
