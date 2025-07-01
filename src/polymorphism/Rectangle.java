package polymorphism;

public class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle (double length, double width) {
        if (length < 0 || width < 0) throw new IllegalArgumentException("Length and width must be non-negative");

        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length * width);
    }

    public void setDimensions (double length, double width) {
        this.length = length;
        this.width = width;
    }

    public void setDimensions (double side) {
        this.length = side;
        this.width = side;
    }
}
