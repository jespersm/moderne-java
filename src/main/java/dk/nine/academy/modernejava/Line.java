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
        int width = from.getX() - to.getX();
        int height = from.getY() - to.getY();
        return sqrt(width * width + height * height);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + from.hashCode();
        result = prime * result + to.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Line))
            return false;
        Line other = (Line) obj;
        if (!from.equals(other.from))
            return false;
        if (!to.equals(other.to))
            return false;
        return true;
    }

    @Override
    public Point getAnchor() {
        return from;
    }

}
