package ATM;

import java.util.List;
import java.util.Scanner;

public class BankingService {
    static Scanner scanner = new Scanner(System.in);
    static Account currentLoggedInAccount;

    public static void signupAccount()
    {
        String userName;
        int password;
        try
        {
            System.out.print("Enter user name : ");
            userName = scanner.nextLine();

            System.out.print("Enter password : ");
            password = scanner.nextInt();
            scanner.nextLine();
            Account account = new Account();
            account.setUsername(userName);
            account.setPassword(password);
            account.setBalance(0);

            DBApp dbApp = new DBApp();
            dbApp.addAccount(account);


        } catch (Exception e) {
            System.out.println("Invalid input!");
        }

    }

    public static void Login()
    {
        System.out.print("Enter your username : ");
        String userName = scanner.nextLine();

        System.out.print("Enter your password : ");
        int password = scanner.nextInt();
        scanner.nextLine();
        DBApp dbApp = new DBApp();
        Account account = dbApp.getAccountByUserName(userName);

        if(account!=null && account.getPassword()==password)
        {
            currentLoggedInAccount = account;
            System.out.println("Welcome back " + currentLoggedInAccount.getUsername().toUpperCase());
            System.out.println("Your Balance : " + currentLoggedInAccount.getBalance());
        }
        else
        {
            System.out.println("Incorrect password or username!");
        }

    }

    public static void Deposit()
    {
        if (currentLoggedInAccount == null) {
            System.out.println("Please login first!");
            return;
        }

        try {
            System.out.print("Enter the amount to deposit : ");
            int depositMoney = scanner.nextInt();
            scanner.nextLine();

            if (depositMoney <= 0) {
                System.out.println("Amount must be greater than 0!");
                return;
            }

            int currentBalance = currentLoggedInAccount.getBalance();
            int newBalance = currentBalance + depositMoney;

            DBApp dbApp = new DBApp();
            dbApp.updateBalance(currentLoggedInAccount.getUsername(), newBalance);

            currentLoggedInAccount.setBalance(newBalance);

            Transaction transaction = new Transaction();
            transaction.setTransactionType("DEPOSIT");
            transaction.setAmount(depositMoney);
            transaction.setUser_name(currentLoggedInAccount.getUsername());
            dbApp.addTransaction(transaction);

            System.out.println("✅ Deposit successful!");
            System.out.println("💰 New balance: " + newBalance);



        } catch (Exception e) {
            System.out.println("Invalid amount!");
            scanner.nextLine();
        }

    }
    public static void Withdraw() {
        if (currentLoggedInAccount == null) {
            System.out.println("Please login first!");
            return;
        }

        try {
            System.out.print("Enter the amount to withdraw : ");
            int withdrawMoney = scanner.nextInt();
            scanner.nextLine();

            if (withdrawMoney <= 0) {
                System.out.println("Amount must be greater than 0!");
                return;
            }

            int currentBalance = currentLoggedInAccount.getBalance();

            if (currentBalance < withdrawMoney) {
                System.out.println("Insufficient balance!");
                return;
            }

            int newBalance = currentBalance - withdrawMoney;

            DBApp dbApp = new DBApp();
            dbApp.updateBalance(currentLoggedInAccount.getUsername(), newBalance);

            currentLoggedInAccount.setBalance(newBalance);

            Transaction transaction = new Transaction();
            transaction.setTransactionType("WITHDRAW");
            transaction.setAmount(withdrawMoney);
            transaction.setUser_name(currentLoggedInAccount.getUsername());
            dbApp.addTransaction(transaction);

            System.out.println("✅ Withdraw successful!");
            System.out.println("💰 New balance: " + newBalance);



        } catch (Exception e) {
            System.out.println("Invalid amount!");
            scanner.nextLine();
        }
    }

    public static void CurrentTransaction()
    {
        DBApp dbApp = new DBApp();
        List<Transaction> transactions = DBApp.getTransactionByUserName(currentLoggedInAccount.getUsername());
        Transaction current = transactions.getLast();

        System.out.println();
        System.out.println("Transaction");
        System.out.println("*******************************");
        System.out.println("Transaction ID - " + current.getTransactionId());
        System.out.println("Transaction Type - " + current.getTransactionType());
        System.out.println("Amount - " + current.getAmount());
        System.out.println("User Name - " + current.getUser_name().toUpperCase());
    }

    public static void ShowTransactions()
    {
        if (currentLoggedInAccount == null) {
            System.out.println("Please login first!");
            return;
        }
        System.out.println();

        DBApp dbApp = new DBApp();
        List<Transaction> transactions = DBApp.getTransactionByUserName(currentLoggedInAccount.getUsername());
        int depositCount = 0;
        int withdrawCount = 0;
        System.out.println("Your Transactions");
        for(Transaction transaction : transactions)
        {
            System.out.println("*******************************");
            System.out.println("Transaction ID - " + transaction.getTransactionId());
            System.out.println("Transaction Type - " + transaction.getTransactionType());
            System.out.println("Amount - " + transaction.getAmount());
            System.out.println("User Name - " + transaction.getUser_name().toUpperCase());
            System.out.println();
            if(transaction.getTransactionType().equals("DEPOSIT"))
            {
                depositCount++;
            }
            else
            {
                withdrawCount++;
            }
        }
        System.out.println("Deposit Transactions - " + depositCount);
        System.out.println("Withdraw Transactions - " + withdrawCount);

    }

    public static void Logout()
    {
        if (currentLoggedInAccount == null)
        {
            System.out.println("You are not logged in❗");
            return;
        }

        System.out.println("Goodbye, " + currentLoggedInAccount.getUsername().toUpperCase() + "👋");
        System.out.println("You have been successfully logged out.");
        currentLoggedInAccount = null;

    }

    public static void CheckBalance() {
      if(currentLoggedInAccount == null)
    {
        System.out.println("You have to log in first");
        return;
    }
        System.out.println("Current account : " + currentLoggedInAccount.getUsername().toUpperCase());
        System.out.println("Your Current Balance : "+ currentLoggedInAccount.getBalance());

    }
//
//    public static void Deposit()
//    {
//        try{
//            System.out.print("Enter the amount you want to deposit : ");
//            int depositMoney = scanner.nextInt();
//
//            int currentBalance = currentUser.getBalance();
//            currentUser.setBalance(currentBalance + depositMoney);
//            System.out.println("Successful✅");
//
//            Transaction transaction = new Transaction("DEPOSIT",depositMoney,currentUser.getUserId());
//            transactionHistory.add(transaction);
//
//        } catch (Exception e) {
//            System.out.println("Invalid amount❗");
//            scanner.nextLine();
//            System.out.println();
//        }
//
//    }
//    public static void Withdraw()
//    {
//        try{
//            System.out.print("Enter the amount you want to withdraw : ");
//            int withdrawMoney = scanner.nextInt();
//            if(withdrawMoney > currentUser.getBalance())
//            {
//                System.out.println("Insufficient amount❗");
//            }
//            else
//            {
//                int currentBalance = currentUser.getBalance();
//                currentUser.setBalance(currentBalance - withdrawMoney);
//                System.out.println("Successful✅");
//                Transaction transaction = new Transaction("WITHDRAW",withdrawMoney,currentUser.getUserId());
//                transactionHistory.add(transaction);
//            }
//        } catch (Exception e) {
//            System.out.println("Invalid amount❗");
//            scanner.nextLine();
//            System.out.println();
//        }
//    }
//
//    public static void ShowTransactionHistory() {
//        boolean hasTransactions = false;
//        for (Transaction t : transactionHistory) {
//            if (t.getUserId() == currentUser.getUserId()) {
//                t.displayTransaction();
//                System.out.println();
//                hasTransactions = true;
//            }
//        }
//
//        if (!hasTransactions) {
//            System.out.println("No transactions for this user❗");
//        }
//    }
}
