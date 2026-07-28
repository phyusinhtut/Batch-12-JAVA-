import java.util.Scanner;
public class BankingProgram {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your initial balance : ");
        int balance = scanner.nextInt();
        int choice = 0;
        while(choice != 4)
        {
            System.out.println("-------------------------------");

            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice : ");
            choice = scanner.nextInt();
            if (choice > 4 || choice < 0)
            {
                System.out.println("Invalid Choice!");
            }

            switch (choice)
            {
                case 1:
                    System.out.print("Enter the amount you want to deposit : ");
                    int depositMoney = scanner.nextInt();
                    balance += depositMoney;
                    break;
                case 2:
                    System.out.print("Enter the amount you want to withdraw : ");
                    int withdraw = scanner.nextInt();
                    if(withdraw > balance)
                    {
                        System.out.println("Insufficient amount!");
                    }
                    else
                    {
                        balance -= withdraw;
                    }
                    break;
                case 3:
                    System.out.println("Your Balance : " + balance);
                    break;
                case 4:
                    System.out.println("Thank you");
                    break;

            }
        }
        scanner.close();

    }
}
