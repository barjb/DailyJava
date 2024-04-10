package j21.patternmatching;

public class App {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(3,2);
        System.out.println(getPerimeter(r));
        Circle c = new Circle(2);
        System.out.println(getPerimeter(c));
        test("m");
        test("long");
    }
    public static double getPerimeter(Shape s){
        return switch (s){
            case Rectangle r -> 2*r.length()+ 2* r.width();
            case Circle c -> 2*Math.PI * c.radius();
            default -> throw new IllegalArgumentException("Shape unrecognized");
        };
    }
    public static void test(Object obj){
        switch (obj){
            case String s when s.length() == 1 -> System.out.println("short: " + s);
            case String s -> System.out.println(s);
            default -> System.out.println("Not a string");
        }
    }
}
