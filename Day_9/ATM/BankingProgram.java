package ATM;
import java.util.Scanner;

import static ATM.BankingService.*;

public class
BankingProgram {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        int choice = 0;
        while(choice != 9)
        {
            System.out.println("➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖");
            System.out.println("▫️                             ▫️");
            System.out.println("▫️         BANKING APP         ▫️");
            System.out.println("▫️                             ▫️");
            System.out.println("➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖");
            System.out.println("▫️1. Create Account            ▫️️");
            System.out.println("▫️2. Login                     ▫️️");
            System.out.println("▫️3. Logout                    ▫️️");
            System.out.println("▫️4. Deposit Money             ▫️️");
            System.out.println("▫️5. Withdraw Money            ▫️️");
            System.out.println("▫️6. Check Balance             ▫️️");
            System.out.println("▫️7. Show Transactions         ▫️️");
            System.out.println("▫️8. Delete Account            ▫️️");
            System.out.println("▫️9. Exit                      ▫️️");
            System.out.println("➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖");
            System.out.print("Enter your choice : ");
            choice = scanner.nextInt();

            System.out.println("➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖");

            if (choice > 10 || choice < 0)
            {
                System.out.println("Invalid Choice!");
            }

            switch (choice)
            {
                case 1:
                    signupAccount();
                    break;
                case 2:
                    Login();
                    break;
                case 3:
                    Logout();
                    break;
                case 4:
                   Deposit();
                   CurrentTransaction();
                   break;
                case 5:
                    Withdraw();
                    CurrentTransaction();
                    break;
                case 6:
                    CheckBalance();
                    break;
                case 7:
                    ShowTransactions();
                    TransactionFile();
                    break;
                case 8:
                    DeleteAccount();
                    break;
                case 9:
                    System.out.println("Thank you😊");
                    break;

            }
        }
        scanner.close();

    }

}
