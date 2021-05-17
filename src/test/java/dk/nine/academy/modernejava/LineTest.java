package dk.nine.academy.modernejava;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    public void testLengthStraight() {
        var p1 = new Point(0, 1);
        var p2 = new Point(10, 1);
        var p1p2 = new Line(p1, p2);

        assertEquals(10.0, p1p2.getLength(), 0.000001);
    }

    @Test
    public void testLengthAngle() {
        var p1 = new Point(0, 0);
        var p2 = new Point(3, 4);
        var p1p2 = new Line(p1, p2);

        assertEquals(5.0, p1p2.getLength(), 0.000001);
    }

}
