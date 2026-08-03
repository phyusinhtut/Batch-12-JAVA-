import java.util.Scanner;
public class TicTacToeGame {
    static char[][] board = new char[3][3];
    static char currentPlayer = 'X';

    public static void main(String[] args) {
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
                board[i][j] = '-';
            }
        }
    }

    public static void printBoard() {

        System.out.println("    0 | 1 | 2 ");
        System.out.println("   --- --- --- ");

        for (int i = 0; i < 3; i++)
        {
            System.out.print(i + " | ");
            for (int j = 0; j < 3; j++)
            {
              System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("   --- --- --- ");
        }
    }

    public static void playerMove() {
        Scanner scanner = new Scanner(System.in);
        int row , col;

        while (true)
        {
            System.out.println("Player " + currentPlayer +"'s turn...");
            System.out.print("Please enter row(0-2) && col(0-2) : ");
            row = scanner.nextInt();
            col = scanner.nextInt();

            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-')
            {
                board[row][col] = currentPlayer;
                break;
            }
            else
            {
                System.out.println("No free space found! Choose another spot...");
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
                if (board[i][j] == '-')
                    return false;
            }
        }
        return true;
    }

    public static void switchPlayer()
    {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
}
