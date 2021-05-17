package dk.nine.academy.modernejava;

import static java.lang.Math.sqrt;
import static java.util.Objects.requireNonNull;

public class Line implements Shape {

    private final Point from, to;

    public Line(Point from, Point to) {
        requireNonNull(from);
        requireNonNull(to);
        this.from = from;
        this.to = to;
    }

    public Point getFrom() {
        return from;
    }

    public Point getTo() {
        return to;
    }

    @Override
    public ShapeKind getKind() {
        return ShapeKind.LINE;
    }

    @Override
    public double getLength() {
        var width = from.getX() - to.getX(); // Java 10
        var height = from.getY() - to.getY(); // Java 10
        return sqrt(width * width + height * height);
    }

    @Override
    public int hashCode() {
        var prime = 31; // Java 10
        var result = 1; // Java 10
        result = prime * result + from.hashCode();
        result = prime * result + to.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        // Java 16
        return obj instanceof Line other
                && from.equals(other.from)
                && to.equals(other.to);
    }

    @Override
    public Point getAnchor() {
        return from;
    }

}
