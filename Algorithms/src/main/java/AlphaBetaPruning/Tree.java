package AlphaBetaPruning;

public class Tree {
    private Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    Node alphabeta(Node node, int depth, int alpha, int beta, boolean maximizingPlayer) {
        node.countChildren();
        if (depth == 0 || node.getChildren().isEmpty()) {
            return node;
        }
        Node toreturn = null;
        if (maximizingPlayer) {
            int value = Integer.MIN_VALUE;
            for (var current :
                    node.getChildren()) {
                Node newValue = alphabeta(new Node(current), depth - 1, alpha, beta, false);
                if (newValue.getValue() > value) {
                    value = newValue.getValue();
                    toreturn = new Node(current);
                }
                if (value > beta) {
                    break;
                }
                alpha = Math.max(alpha, value);
            }
            return toreturn;
        } else {
            int value = Integer.MAX_VALUE;

            for (var current : node.getChildren()) {
                Node newValue = alphabeta(new Node(current), depth - 1, alpha, beta, true);
                if (newValue.getValue() < value) {
                    value = newValue.getValue();
                    toreturn = new Node(current);
                }
                if (value < alpha) {
                    break;
                }
                beta = Math.min(beta, value);
            }
            return toreturn;
        }
    }
}
