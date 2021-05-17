package dk.nine.academy.modernejava;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class PointTest {

    @Test
    public void testPointAsJSON() throws Throwable {
        var p1 = new Point(0, 1);

        // Java 15
        assertEquals("""
                 {
                   "x" : 0,
                   "y" : 1
                 }""", p1.asJson());
    }

}
