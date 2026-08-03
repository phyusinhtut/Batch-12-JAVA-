import java.util.Scanner;
public class TicTacToe {
    static char[][] board = new char[3][3];
    static char currentPlayer = '❌';

    public static void main(String[] args) {
        System.out.println("Tic Tac Toe Game");
        System.out.println("****************");
        initializeBoard();

        while (true)
        {
            printBoard();
            playerMove();

            if (checkWin())
            {
                printBoard();
                System.out.println("Player " + currentPlayer + " Win!");
                break;
            }

            if (isBoardFull())
            {
                printBoard();
                System.out.println("Draw!");
                break;
            }

            switchPlayer();
        }
    }

    public static void initializeBoard()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                board[i][j] = '➖';
            }
        }
    }

    public static void printBoard() {

        System.out.println("   ------ ------ ------ ");

        for (int i = 0; i < 3; i++)
        {
            System.out.print("  |  ");
            for (int j = 0; j < 3; j++)
            {
                System.out.print(board[i][j] + "  |  ");
            }
            System.out.println();
            System.out.println("   ------ ------ ------ ");
        }
    }

    public static void playerMove() {
        Scanner scanner = new Scanner(System.in);
        int row;
        int rowIndex = 0;
        int colIndex = 0;
        char currentSpot;

        while (true)
        {
            System.out.println("Player " + currentPlayer + "'s turn...");
            System.out.print("Please enter (1-9): ");
            row = scanner.nextInt();

            switch (row) {
                case 1: rowIndex = 0; colIndex = 0; break;
                case 2: rowIndex = 0; colIndex = 1; break;
                case 3: rowIndex = 0; colIndex = 2; break;
                case 4: rowIndex = 1; colIndex = 0; break;
                case 5: rowIndex = 1; colIndex = 1; break;
                case 6: rowIndex = 1; colIndex = 2; break;
                case 7: rowIndex = 2; colIndex = 0; break;
                case 8: rowIndex = 2; colIndex = 1; break;
                case 9: rowIndex = 2; colIndex = 2; break;
                default:
                    System.out.println("Invalid input! Please enter 1-9.");
                    continue;
            }

            currentSpot = board[rowIndex][colIndex];

            if (currentSpot == '➖')
            {
                board[rowIndex][colIndex] = currentPlayer;
                break;
            }
            else
            {
                System.out.println("That spot is already taken! Choose another spot...");
            }
        }

    }

    public static boolean checkWin()
    {
        for (int i = 0; i < 3; i++)
        {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer)
                return true;
        }

        for (int j = 0; j < 3; j++)

        {
            if (board[0][j] == currentPlayer && board[1][j] == currentPlayer && board[2][j] == currentPlayer)
                return true;
        }

        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer)
            return true;

        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)
            return true;

        return false;
    }

    public static boolean isBoardFull()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (board[i][j] == '➖')
                    return false;
            }
        }
        return true;
    }

    public static void switchPlayer()
    {
        currentPlayer = (currentPlayer == '❌') ? '⭕' : '❌';
    }
}

