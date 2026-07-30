import java.util.Scanner;
public class Factorial {

    public static int findFactorial(int n) {
        int result = 1;
        for (int i = n; i > 0; i--) {
            result = result * i;
        }
        return result;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int num = scanner.nextInt();
        System.out.println(findFactorial(num));
        scanner.close();
    }
}
