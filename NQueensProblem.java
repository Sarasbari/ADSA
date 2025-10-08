import java.util.Scanner;

public class NQueensProblem
{
    static final int MAX = 20; // maximum board size

    // Function to print the chessboard configuration
    static void printBoard(int[][] board, int n)
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Function to check if a queen can be safely placed on board[row][col]
    static boolean isSafe(int[][] board, int row, int col, int n)
    {
        int i, j;

        // Check column
        for (i = 0; i < row; i++)
        {
            if (board[i][col] == 1)
                return false;
        }

        // Check upper-left diagonal
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
        {
            if (board[i][j] == 1)
                return false;
        }

        // Check upper-right diagonal
        for (i = row, j = col; i >= 0 && j < n; i--, j++)
        {
            if (board[i][j] == 1)
                return false;
        }

        return true;
    }

    // Recursive function to solve the N-Queen problem
    static boolean solveNQ(int[][] board, int row, int n)
    {
        // Base case: all queens are placed
        if (row == n)
        {
            printBoard(board, n);
            return true;
        }

        boolean res = false;

        // Try placing a queen in each column
        for (int col = 0; col < n; col++)
        {
            if (isSafe(board, row, col, n))
            {
                board[row][col] = 1; // Place queen

                // Recur to place rest of the queens
                res = solveNQ(board, row + 1, n) || res;

                // Backtrack: remove queen
                board[row][col] = 0;
            }
        }

        return res;
    }

    // Function to initialize board and start solving
    static void NQueens(int n)
    {
        int[][] board = new int[MAX][MAX]; // Initialize board with 0

        if (!solveNQ(board, 0, n))
            System.out.println("No solution exists");
    }

    // Main function
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of queens: ");
        int n = sc.nextInt();

        NQueens(n);

        sc.close();
    }
}
