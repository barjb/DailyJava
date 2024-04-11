package j16.records;

public record Rectangle(double length, double width) {
    // explicit canonical
    //    public Rectangle(double length, double width) {
//        if (length <= 0 || width <= 0) {
//            throw new java.lang.IllegalArgumentException(
//                    String.format("Invalid dimensions: %f, %f", length, width));
//        }
//        this.length = length;
//        this.width = width;
//    }
    // compact constructor
    public Rectangle{
        if(length <= 0 || width <= 0){
            throw new IllegalArgumentException(String.format("Invalid dimetions %f %f", length, width));
        }
    }
}
