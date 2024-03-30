package AlphaBetaPruning;

import java.util.Arrays;
import java.util.List;

public class TicTacToe {
    public static final byte X_REPR = 1;
    public static final byte O_REPR = 4;
    private final byte[] board;
    private boolean sideToMove; // true X, false O

    public TicTacToe() {
        board = new byte[9];
    }

    public void move(int field) {
        // 0, 1, 2
        // 3, 4, 5,
        // 6, 7, 8
        board[field] = sideToMove ? X_REPR : O_REPR;
        sideToMove = !sideToMove;
    }

    public boolean isGameOver() {
        int[][] lines = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
        return Arrays.stream(lines).anyMatch(ints -> {
            int reduced = Arrays.stream(ints).reduce(0, (subtotal, element) -> subtotal + board[element]);
            return reduced == 3 || reduced == 12;
        });
    }
}
