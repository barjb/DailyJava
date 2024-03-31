package AlphaBetaPruning;

public class Application {
    public static void main(String[] args) {
        TicTacToe t1 = new TicTacToe(false);
        t1.move(0);
        System.out.println(t1);
        t1.move(1);
        t1.move(3);
        t1.move(2);
        t1.move(6);
        System.out.println(t1);
    }
}
