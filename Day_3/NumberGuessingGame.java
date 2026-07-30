import java.util.Scanner;
import java.util.Random;
public class NumberGuessingGame {
    public static void welcomeMenu()
    {
        System.out.println("Number Guessing Game");
        System.out.println("********************");
        System.out.println("Number is chosen between 1 and 100");
    }

    public static void guessNumber()
    {
        int attemps = 5;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int chosenNum = random.nextInt(1,101);

        for(int i = 0 ; i<attemps ; i++)
        {

            System.out.print("Enter your guess : ");
            int userInput = scanner.nextInt();
            scanner.nextLine();
            if(userInput == chosenNum)
            {
                System.out.println("Congratulations... You Win");
                System.out.println("The Number is - " + chosenNum);
            }
            else if (userInput > chosenNum)
            {
                System.out.println("Your number is greater than the Chosen Number!");
            }
            else
            {
                System.out.println("Your number is less than the Chosen Number!");
            }
        }
        System.out.println("You used all your attemps!");

        System.out.print("PlayAgain? (yes/no) : ");
        String isPlaying = scanner.nextLine();

        if (isPlaying.equals("yes"))
        {
            guessNumber();
        }
        else
        {
            System.out.println("Thank you");
        }
    }
    public static void main(String[] args)
    {
        welcomeMenu();
        guessNumber();
    }
}
