import java.util.Scanner;
public class ReverseString {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a String : ");
        String userInput = scanner.nextLine();
        String reversed = "";
        for (int i = userInput.length() - 1; i >= 0; i--) {
           reversed += userInput.charAt(i);
        }
        System.out.println("Reversed String : "+reversed);
        scanner.close();
    }
}
