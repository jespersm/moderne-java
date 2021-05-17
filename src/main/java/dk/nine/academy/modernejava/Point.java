package dk.nine.academy.modernejava;

import com.fasterxml.jackson.annotation.JsonProperty;

// Java 16
public primitive record Point(@JsonProperty int x, @JsonProperty int y) implements Shape {

    @Override
    public Point getAnchor() {
        return this;
    }

    @Override
    public ShapeKind getKind() {
        return ShapeKind.POINT;
    }

}
