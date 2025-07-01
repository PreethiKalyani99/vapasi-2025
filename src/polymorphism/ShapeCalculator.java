package polymorphism;

import java.util.ArrayList;
import java.util.List;

public class ShapeCalculator {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Rectangle rectangle = new Rectangle(3,5);
        Shape triangle = new Triangle(3, 4, 5);

        List<Shape> shapes = new ArrayList<Shape>();

        shapes.add(circle);
        shapes.add(rectangle);
        shapes.add(triangle);

        for (Shape shape: shapes) {
            System.out.println("Area: " + shape.calculateArea());
            System.out.println("Perimeter: " + shape.calculatePerimeter());
            System.out.println("-----------------");
        }

        rectangle.setDimensions(12);
    }
}
