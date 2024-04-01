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
        if (maximizingPlayer) {
            int value = Integer.MIN_VALUE;
            for (var current :
                    node.getChildren()) {
                value = Math.max(value,alphabeta(new Node(current),depth-1,alpha,beta,false));
                if(value > beta){
                    break;
                }
                alpha = Math.max(alpha,value);
            }
            return value;
        } else {
            int value = Integer.MAX_VALUE;
            for(var current: node.getChildren()){
                value = Math.min(value,alphabeta(new Node(current),depth-1,alpha,beta,true));
                if(value < alpha){
                    break;
                }
                beta = Math.min(beta,value);
            }
            return value;
        }
    }
}
