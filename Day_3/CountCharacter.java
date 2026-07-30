import java.util.Scanner;
public class CountCharacter {
    public static void countChar()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence : ");
        String userInput = scanner.nextLine();

        int letterCount = 0;
        int digitCount =0;
        int specialCount =0;

        for(int i = 0; i<userInput.length(); i++)
        {
            if(userInput.charAt(i) == '!' || userInput.charAt(i) == '@' || userInput.charAt(i) == '#'
            || userInput.charAt(i) == '$' || userInput.charAt(i) == '%' || userInput.charAt(i) == '&'
            || userInput.charAt(i) == '*')
            {
                specialCount++;
            }
            else if(Character.isDigit(userInput.charAt(i)))
            {
                digitCount++;
            }
            else {
                letterCount++;
            }
        }
        System.out.println("Letter Count : " + letterCount);
        System.out.println("Digit Count : " + digitCount);
        System.out.println("Special Character Count : " + specialCount);

        scanner.close();
    }
    public static void main(String[] args){
        countChar();
    }
}
