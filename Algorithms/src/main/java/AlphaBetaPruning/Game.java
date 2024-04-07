package AlphaBetaPruning;

import java.util.Scanner;

public class Game {
    private final TicTacToe position;
    private final Tree engine = new Tree(null);
    private final Scanner scanner = new Scanner(System.in);

    public Game() {
        position = new TicTacToe(true);
    }

    boolean isGameFinished() {
        return position.isFinished() || position.isGameResultDecided();
    }

    void info() {
        System.out.println("Type [1-9] to move");
        System.out.println("| 1| 2| 3|\n ________\n| 4| 5| 6|\n ________\n| 7| 8| 9|");
    }

    void getMove() {
        if (position.getSideToMove()) {
            int index = scanner.nextInt();
            position.move(index - 1);
        } else {
            Node root = new Node(position);
            engine.setRoot(root);
            int maxDepth = 9;
            Node node = engine.alphabeta(root, maxDepth - position.getCurrentMove(), Integer.MIN_VALUE, Integer.MAX_VALUE, false);
            position.move(position.getMove(node.getPostition()));
        }
    }

    void showPosition() {
        System.out.println(position);
    }
    String getResult(){
        return position.stringValue();
    }
}
