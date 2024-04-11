package j16.patternsinstanceof;

public interface Shape {
    public static double getPerimeter(Shape shape){
        if(shape instanceof Rectangle r){
            return 2* r.width() + 2*r.height();
        } else if (shape instanceof Circle c) {
            return 2*Math.PI*c.radius();
        }else throw new IllegalArgumentException("Unrecognized shape");
    }
}
record Rectangle(double width, double height) implements Shape{

}
record Circle(double radius) implements Shape{}