package dk.nine.academy.modernejava;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Point implements Shape {

    @JsonProperty
    private final int x, y;

    public Point(@JsonProperty int x, @JsonProperty int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public Point getAnchor() {
        return this;
    }

    @Override
    public ShapeKind getKind() {
        return ShapeKind.POINT;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Point))
            return false;
        Point other = (Point) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }
}
