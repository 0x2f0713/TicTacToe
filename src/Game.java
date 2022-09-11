/**
 * Created by CCNE on 09/09/2022.
 */

import java.util.Scanner;

public class Game {

    private static Board board;
    private static Scanner scanner;

    public static void initialize() {
        board = new Board();
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        boolean running = true;
        boolean turn = true;
        boolean step;
        int moveCount = 0;
        initialize();

        while (running) {
            System.out.println((turn ? "X" : "O") + " turn");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            step = board.setCellStatus(row, col, turn);
            if(step) {
                moveCount++;
                running = board.checkGameOver(row,col,turn, moveCount);
                turn = !turn;
                board.printBoard();
            }
            // running = false;
        }
    }
}
