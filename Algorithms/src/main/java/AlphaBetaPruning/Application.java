package AlphaBetaPruning;

public class Application {
    public static void main(String[] args) {
        Game g = new Game();
        g.info();
        while (!g.isGameFinished()){
            g.getMove();
            System.out.println("==========");
            g.showPosition();
        }
        System.out.println("RESULT: " +g.getResult());
    }
}
