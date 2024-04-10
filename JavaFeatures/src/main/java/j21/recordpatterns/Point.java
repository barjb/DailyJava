package j21.recordpatterns;

public record Point(double x,double y) {
    static void printAngleFromXAxis(Object obj){
        if(obj instanceof Point(var x, var y)){
            System.out.println(Math.toDegrees(Math.atan2(y,x)));
        }
    }
}
