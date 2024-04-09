package j22.unusedvariablesandpatterns;

import java.text.ParsePosition;

public class App {
    public static int calcArea(GeometricShape figure){
        return switch (figure){
            case Point _, Line _ -> 0;
            case Triangle (Point a, Point b, Point c) -> triangleArea(a,b,c);
            case Square (Point a, Point b, Point c, Point d) -> squareArea(a,b,c,d);
        };
    }
    public static int triangleArea(Point a, Point b, Point c){
        return 1;
    }
    public static int squareArea(Point a, Point b, Point c, Point d){
        return 2;
    }
}
