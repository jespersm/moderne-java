package dk.nine.academy.modernejava;

import static java.lang.Math.PI;

public final class Circle implements Shape {

    private final Point center;
    private final double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + center.hashCode();
        result = prime * result + Double.hashCode(radius);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Circle))
            return false;
        Circle other = (Circle) obj;
        if (!center.equals(other.center))
            return false;
        if (Math.abs(radius - other.radius) > 0.00001)
            return false;
        return true;
    }

    @Override
    public Point getAnchor() {
        return center;
    }

}
