import java.util.Scanner;
public class Vowels {
    public static void countVowels(String input)
    {

        int count=0;
        for(int i =0 ; i< input.length();i++)
        {
            if(input.charAt(i) == 'a' ||input.charAt(i) == 'A' ||input.charAt(i) == 'e' ||input.charAt(i) == 'E' ||
                    input.charAt(i) == 'i' ||input.charAt(i) == 'I' ||input.charAt(i) == 'o' || input.charAt(i) == 'O' ||
                    input.charAt(i) == 'u' || input.charAt(i) == 'U')
            {
                count++;
            }
        }
        System.out.println("There is "+ count +" vowels!");
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence : ");
        String input = scanner.nextLine();
        countVowels(input);
        scanner.close();
    }
}
