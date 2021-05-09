package dk.nine.academy.modernejava;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    public void testLengthStraight() {
        Point p1 = new Point(0, 1);
        Point p2 = new Point(10, 1);
        Line p1p2 = new Line(p1, p2);

        assertEquals(10.0, p1p2.getLength(), 0.000001);
    }

    @Test
    public void testLengthAngle() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 4);
        Line p1p2 = new Line(p1, p2);

        assertEquals(5.0, p1p2.getLength(), 0.000001);
    }

}
