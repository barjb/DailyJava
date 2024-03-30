package AlphaBetaPruning;

public class Application {
    public static void main(String[] args) {
        TicTacToe t1 = new TicTacToe();
        t1.move(0);
        boolean result = t1.isGameOver();
        System.out.println(result);
        t1.move(1);
        t1.move(3);
        t1.move(2);
        t1.move(6);
        result = t1.isGameOver();
        System.out.println(result);
    }
}
