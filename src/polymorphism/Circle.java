package polymorphism;

public class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        if (radius < 0) throw new IllegalArgumentException("Radius cannot be negative");

        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}
