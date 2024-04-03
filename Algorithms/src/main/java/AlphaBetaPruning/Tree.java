package AlphaBetaPruning;

public class Tree {
    private Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    int alphabeta(Node node, int depth, int alpha, int beta, boolean maximizingPlayer) {
        node.countChildren();
        if (depth == 0 || node.getChildren().isEmpty()) {
            return node.getValue();
        }
        TicTacToe toreturn = null;
        if (maximizingPlayer) {
            int value = Integer.MIN_VALUE;
            for (var current :
                    node.getChildren()) {
//                value = Math.max(value,alphabeta(new Node(current),depth-1,alpha,beta,false));
                int newValue = alphabeta(new Node(current), depth - 1, alpha, beta, false);
                if (newValue > value) {
                    value = newValue;
                    toreturn = current;
                }
                if (value > beta) {
                    break;
                }
                alpha = Math.max(alpha, value);
            }
            System.out.println(toreturn);
            return value;
        } else {
            int value = Integer.MAX_VALUE;

            for (var current : node.getChildren()) {
                int newValue = alphabeta(new Node(current), depth - 1, alpha, beta, true);
//                value = Math.min(value, alphabeta(new Node(current), depth - 1, alpha, beta, true));
                if (newValue < value) {
                    value = newValue;
                    toreturn = current;
                }
                if (value < alpha) {
                    break;
                }
                beta = Math.min(beta, value);
            }
            return value;
        }
    }
}
