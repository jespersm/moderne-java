package dk.nine.academy.modernejava;

import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import dk.nine.academy.modernejava.util.TrigUtil;

class TrigUtilTest {

    @Test
    void testPointInk() {
        var p1 = new Point(0, 0);

        assertEquals(.1, TrigUtil.inkAmount(p1));
    }

    @Test
    void testLineLength() {
        var p1 = new Point(0, 0);
        var p2 = new Point(10, 10);
        var p1p2 = new Line(p1, p2);

        assertEquals(14.1, TrigUtil.inkAmount(p1p2), 0.1);
    }

    @Test
    void testCircleLength() {
        var p1 = new Point(0, 0);
        var c = new Circle(p1, 10);

        assertEquals(2 * PI * 10 + (PI * 10 * 10) / 10, TrigUtil.inkAmount(c), 0.01);
    }

    @Test
    void testPointIsSinglePoint() {
        var p1 = new Point(0, 0);
        assertTrue(TrigUtil.isSinglePoint(p1));
        assertTrue(TrigUtil.isSinglePoint(p1));
    }

    @Test
    void testCircleIsSinglePoint() {
        var p1 = new Point(32, 41);
        assertTrue(TrigUtil.isSinglePoint(new Circle(p1, 0)));
        assertFalse(TrigUtil.isSinglePoint(new Circle(p1, 42)));
    }

    @Test
    void testLineIsSinglePoint() {
        var p1_1 = new Point(1, 1);
        var p1_2 = new Point(1, 1);
        assertTrue(TrigUtil.isSinglePoint(new Line(p1_1, p1_2)));

        var p2 = new Point(2, 2);
        assertFalse(TrigUtil.isSinglePoint(new Line(p1_1, p2)));
    }

    @Test
    void testGetBiggest() {
        assertEquals(Optional.empty(), TrigUtil.getBiggest(Collections.emptyList()));

        var p1 = new Point(2, 1);
        var p2 = new Point(3, 2);
        assertEquals(Optional.of(p1), TrigUtil.getBiggest(List.of(p1, p2)));

        var c1 = new Circle(p1, 10);
        var c2 = new Circle(p1, 20);
        assertEquals(Optional.of(c2), TrigUtil.getBiggest(List.of(c1, c2)));
    }

}
