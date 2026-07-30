import java.util.Scanner;
public class Table {

    public static void printTable(int number,int row)
    {
        if(row > 50)
        {
            System.out.println("Row cannot be greater than 50!");
        }
        else
        {
            for(int i = 1; i <= row; i++)
            {
                System.out.println(number +" x " + i+ " = "+(number*i));
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int number = scanner.nextInt();

        System.out.print("Enter row numbers : ");
        int row = scanner.nextInt();
        printTable(number,row);

        scanner.close();
    }
}
