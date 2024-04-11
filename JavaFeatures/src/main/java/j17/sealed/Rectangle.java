package j17.sealed;

public sealed class Rectangle extends Shape permits FilledRectangle{
    public double length,width;
}
