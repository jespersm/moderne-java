package dk.nine.academy.modernejava.util;

import static java.lang.Math.max;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import dk.nine.academy.modernejava.Circle;
import dk.nine.academy.modernejava.Line;
import dk.nine.academy.modernejava.Point;
import dk.nine.academy.modernejava.Shape;

public class TrigUtil {

    public static double inkAmount(Shape s) {
        // Java 14
        return switch (s.getKind()) {
        case POINT -> 0.1;
        case SURFACE -> s.getArea() / 10 + s.getEdgeLength();
        case LINE -> max(0.1, s.getLength());
        default -> {
            System.err.println("Hov, kender ikke linjelængden af en " + s);
            yield 1; // bedste mands bedste bud
        }
        };
    }

    public static boolean isSinglePoint(Shape s) {
        // Java 16
        if (s instanceof Point) {
            return true;
        } else if (s instanceof Circle c && c.getRadius() == 0.0) {
            return true;
        } else if (s instanceof Line l && l.getFrom().equals(l.getTo())) {
            return true;
        }
        return false;
    }

    public static Optional<Shape> getBiggest(List<Shape> shapes) {
        // Java 11
        return shapes.stream().max(Comparator.comparingDouble((var s) -> s.getArea()));

        // Eller: Comparator.comparingDouble(s -> s.getArea())
        // Eller: Comparator.comparingDouble(Shape::getArea)
    }

}
