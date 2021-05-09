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
        double length;
        switch (s.getKind()) {
        case POINT:
            length = 0.1;
            break;
        case SURFACE:
            length = s.getArea() / 10 + s.getEdgeLength();
            break;
        case LINE:
            length = max(0.1, s.getLength());
            break;
        default:
            System.err.println("Hov, kender ikke linjelængden af en " + s);
            length = 1; // bedste mands bedste bud
            break;
        }
        return length;
    }

    public static boolean isSinglePoint(Shape s) {
        if (s instanceof Point) {
            return true;
        } else if (s instanceof Circle) {
            Circle c = (Circle) s;
            if (c.getRadius() == 0.0)
                return true;
        } else if (s instanceof Line) {
            Line l = (Line) s;
            if (l.getFrom().equals(l.getTo()))
                return true;
        }
        return false;
    }

    public static Optional<Shape> getBiggest(List<Shape> shapes) {
        return shapes.stream().max(Comparator.comparingDouble((Shape s) -> s.getArea()));
    }

}
