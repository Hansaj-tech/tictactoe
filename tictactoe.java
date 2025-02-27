import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        char currentPlayer = 'X';
        boolean gameEnded = false;
        Scanner scanner = new Scanner(System.in);

        while (!gameEnded) {
            printBoard(board);
            int[] move = getPlayerMove(scanner, board, currentPlayer);
            board[move[0]][move[1]] = currentPlayer;

            if (checkWin(board, currentPlayer)) {
                gameEnded = true;
                System.out.println("Player " + currentPlayer + " wins!");
            } else if (isBoardFull(board)) {
                gameEnded = true;
                System.out.println("The game is a tie!");
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }

        printBoard(board);
    }

    private static void printBoard(char[][] board) {
        System.out.println("Current board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("-----");
            }
        }
    }

    private static int[] getPlayerMove(Scanner scanner, char[][] board, char currentPlayer) {
        int row, col;
        while (true) {
            System.out.println("Player " + currentPlayer + ", enter your move (row and column): ");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                System.out.println("This move is valid. And we are breaking");
                break;
            } else {
                System.out.println("This move is not valid. Try again.");
            }
        }
        return new int[]{row, col};
    }

    private static boolean checkWin(char[][] board, char player) {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
               (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    private static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
