package j21.recordpatterns;

enum Color {RED, GREEN, BLUE}

record ColoredPoint(Point p, Color c) {
}

public record ColoredRectangle(ColoredPoint upperLeft, ColoredPoint lowerRight) {
    static void printXCoordOfUpperLeftPointWithPatterns(ColoredRectangle r) {
        if (r instanceof ColoredRectangle(
                ColoredPoint(Point(var x, var y), var upperLeftColor), var lowerRightCorner
        )) {
            System.out.println("upper-left corner: " + x);
        }
    }
}
