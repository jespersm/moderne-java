package dk.nine.academy.modernejava;

import com.fasterxml.jackson.core.JsonProcessingException;

import dk.nine.academy.modernejava.util.JsonHelper;

public interface Shape {

    Point getAnchor();

    ShapeKind getKind();

    default double getLength() {
        return 0;
    }

    default double getArea() {
        return 0;
    }

    default double getEdgeLength() {
        return 0;
    }

    default String asJson() throws JsonProcessingException {
        return JsonHelper.OBJECT_MAPPER.writeValueAsString(this);
    }
}
