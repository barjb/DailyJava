package AlphaBetaPruning;

import java.util.List;

public class Node {
    public TicTacToe getPostition() {
        return postition;
    }

    private final TicTacToe postition;
    private List<TicTacToe> children;
    public Node(TicTacToe postition) {
        this.postition = postition;
    }

    public void countChildren(){
        this.children = postition.getPossibleMoves();
    }
    public List<TicTacToe> getChildren() {
        return children;
    }

    public int getValue() {
        return postition.value();
    }
}