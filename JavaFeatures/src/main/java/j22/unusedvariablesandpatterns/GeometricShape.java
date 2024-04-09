package j22.unusedvariablesandpatterns;

sealed interface GeometricShape {
}
record Point(int x, int y) implements GeometricShape{}
record Line(Point start, Point end) implements GeometricShape{}
record Triangle(Point pointA, Point pointB, Point pointC) implements GeometricShape{}
record Square(Point pointA, Point pointB, Point pointC, Point pointD) implements GeometricShape{}
