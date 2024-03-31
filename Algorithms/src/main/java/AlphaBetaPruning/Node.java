package AlphaBetaPruning;

import java.util.List;

public class Node {
    private final TicTacToe postition;
    private List<TicTacToe> children;
    private int processed = 0;
    private int bestMove = 0;

    public Node(TicTacToe postition) {
        this.postition = postition;
    }

    public int getProcessed() {
        return processed;
    }

    public int getBestMove() {
        return bestMove;
    }

    public void setBestMove(int bestMove) {
        this.bestMove = bestMove;
    }

    public void setChildren(List<TicTacToe> children) {
        this.children = children;
    }

    public List<TicTacToe> getChildren() {
        return children;
    }

    public int getValue() {
        return postition.value();
    }
}