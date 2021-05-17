package dk.nine.academy.modernejava;

import static java.lang.Math.PI;
import static java.util.Objects.requireNonNull;

// Java 16
public record Circle(Point center, double radius) implements Shape {

    public Circle {
        requireNonNull(center);
    }
    
    @Override
    public ShapeKind getKind() {
        return ShapeKind.SURFACE;
    }

    @Override
    public double getArea() {
        return PI * radius * radius;
    }

    @Override
    public double getEdgeLength() {
        return 2 * PI * radius;
    }

    @Override
    public Point getAnchor() {
        return center;
    }

}
