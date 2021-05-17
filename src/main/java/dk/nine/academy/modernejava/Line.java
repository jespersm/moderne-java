package dk.nine.academy.modernejava;

import static java.lang.Math.sqrt;
import static java.util.Objects.requireNonNull;

// Java 16
public primitive record Line(Point from, Point to) implements Shape {

    public Line {
        requireNonNull(from);
        requireNonNull(to);
    }

    @Override
    public ShapeKind getKind() {
        return ShapeKind.LINE;
    }

    @Override
    public double getLength() {
        var width = from.x() - to.x(); // Java 10
        var height = from.y() - to.y(); // Java 10
        return sqrt(width * width + height * height);
    }

    @Override
    public Point getAnchor() {
        return from;
    }

}
