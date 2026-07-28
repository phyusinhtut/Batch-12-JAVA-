import java.util.Scanner;
public class MyName {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name : ");
        String name = scanner.nextLine();

        for(int i=0 ; i < name.length(); i++)
        {
            System.out.println(name.charAt(i));
        }
        scanner.close();
    }
}
