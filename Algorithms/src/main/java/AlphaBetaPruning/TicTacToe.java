package AlphaBetaPruning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicTacToe {
    public static final byte X_REPR = 1;
    public static final byte O_REPR = 4;
    public static final int X_WIN = 100;
    public static final int O_WIN = 0;
    public static final int DRAW = 50;
    private final byte[] board;
    private int currentMove = 1;
    private boolean sideToMove; // true X, false O

    public TicTacToe(boolean sideToMove) {
        board = new byte[9];
        this.sideToMove = sideToMove;
    }
    public TicTacToe(byte[] board,int currentMove,boolean sideToMove){
        this.board = Arrays.copyOf(board,board.length);
        this.currentMove  = currentMove;
        this.sideToMove = sideToMove;
    }

    public void move(int field) {
        // 0, 1, 2
        // 3, 4, 5,
        // 6, 7, 8
        board[field] = sideToMove ? X_REPR : O_REPR;
        // sideToMove TRUE X
        // sideToMove FALSE O
        sideToMove = !sideToMove;
        ++currentMove;
    }

    public int getCurrentMove() {
        return currentMove;
    }

    public boolean isGameResultDecided() {
        int[][] lines = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
        return Arrays.stream(lines).anyMatch(ints -> {
            int reduced = Arrays.stream(ints).reduce(0, (subtotal, element) -> subtotal + board[element]);
            return reduced == 3 || reduced == 12;
        });
    }

    public boolean isFinished() {
        for (byte b : board) {
            if (b == 0) return false;
        }
        return true;
    }

    public int value() {
        if (!isGameResultDecided() && isFinished()) return DRAW;
        // next is o
        if (isGameResultDecided() && !sideToMove) return X_WIN;
        // next is x
        if (isGameResultDecided() && sideToMove) return O_WIN;
        return -1;
    }
    public List<TicTacToe> getPossibleMoves(){
        if(value() != -1){
            return List.of();
        }
        List<TicTacToe> childrenList = new ArrayList<>();
        for(int i = 0 ; i< board.length; i++){
            if(board[i] == 0){
                byte[] temp = Arrays.copyOf(board,board.length);
                temp[i] = sideToMove ? X_REPR : O_REPR;
                childrenList.add(new TicTacToe(temp,currentMove+1,!sideToMove));
            }
        }
        return childrenList;
    }

    public byte[] getBoard() {
        return board;
    }

    @Override
    public String toString() {
        return "sideToMove: " + (sideToMove ? "X\n" : "O\n") + "board=" + Arrays.toString(board) + '\n' + "IsGameDecided: " + isGameResultDecided() + " isFinished: " + isFinished() + " result: " + value()+ "\n";
    }
}
