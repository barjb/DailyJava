package AlphaBetaPruning;

public class Application {
    public static void main(String[] args) {
        byte[] start = {1,4,1,4,4,1,0,0,0};
        TicTacToe t1 = new TicTacToe(start,7,true);
        Node root = new Node(t1);
        Tree tree = new Tree(root);
        int alphabetaed = tree.alphabeta(tree.getRoot(), 9, Integer.MIN_VALUE, Integer.MAX_VALUE, true);
        System.out.println(alphabetaed);
    }
}
