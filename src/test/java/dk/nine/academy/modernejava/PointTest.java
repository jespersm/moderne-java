package dk.nine.academy.modernejava;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class PointTest {

    @Test
    public void testPointAsJSON() throws Throwable {
        Point p1 = new Point(0, 1);

        assertEquals("{\n  \"x\" : 0,\n  \"y\" : 1\n}", p1.asJson());
    }

}
