/**
 * Created by CCNE on 09/09/2022.
 */
public class Board {

    public Cell[][] board;

    public Board() {
        this.board = new Cell[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.board[i][j] = new Cell();
            }
        }
    }

    public boolean setCellStatus(int row, int col, boolean turn) {
        CellStatus s = turn ? CellStatus.X : CellStatus.O;
        return this.board[row][col].setCellStatus(s);
    }

    public boolean checkGameOver(int x, int y, boolean turn, int moveCount) {
        int n = 3;
        CellStatus s = turn ? CellStatus.X : CellStatus.O;
        // check col
        for (int i = 0; i < n; i++) {
            if (board[x][i].cellStatus != s)
                break;
            if (i == n - 1) {
                // report win for s
                System.out.println(s.toString() + " win");
                return false;
            }
        }

        // check row
        for (int i = 0; i < n; i++) {
            if (board[i][y].cellStatus != s)
                break;
            if (i == n - 1) {
                // report win for s
                System.out.println(s.toString() + " win");
                return false;
            }
        }

        // check diag
        if (x == y) {
            // we're on a diagonal
            for (int i = 0; i < n; i++) {
                if (board[i][i].cellStatus != s)
                    break;
                if (i == n - 1) {
                    // report win for s
                    System.out.println(s.toString() + " win");
                    return false;
                }
            }
        }
        // check anti diag (thanks rampion)
        if (x + y == n - 1) {
            for (int i = 0; i < n; i++) {
                if (board[i][(n - 1) - i].cellStatus != s)
                    break;
                if (i == n - 1) {
                    // report win for s
                    System.out.println(s.toString() + " win");
                    return false;
                }
            }
        }
        // check draw
        if (moveCount == (Math.pow(n, 2) - 1)) {
            // report draw
            System.out.println("Draw!");
            return false;
        }
        return true;
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("[" + ((this.board[i][j].cellStatus == CellStatus.Blank) ? " "
                        : this.board[i][j].cellStatus.toString()) + "]");
            }
            System.out.println();
        }
    }
}
