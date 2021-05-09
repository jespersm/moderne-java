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
        Point p1 = new Point(0, 0);

        assertEquals(.1, TrigUtil.inkAmount(p1));
    }

    @Test
    void testLineLength() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(10, 10);
        Line p1p2 = new Line(p1, p2);

        assertEquals(14.1, TrigUtil.inkAmount(p1p2), 0.1);
    }

    @Test
    void testCircleLength() {
        Point p1 = new Point(0, 0);
        Circle c = new Circle(p1, 10);

        assertEquals(2 * PI * 10 + (PI * 10 * 10) / 10, TrigUtil.inkAmount(c), 0.01);
    }

    @Test
    void testPointIsSinglePoint() {
        Point p1 = new Point(0, 0);
        assertTrue(TrigUtil.isSinglePoint(p1));
        assertTrue(TrigUtil.isSinglePoint(p1));
    }

    @Test
    void testCircleIsSinglePoint() {
        Point p1 = new Point(32, 41);
        assertTrue(TrigUtil.isSinglePoint(new Circle(p1, 0)));
        assertFalse(TrigUtil.isSinglePoint(new Circle(p1, 42)));
    }

    @Test
    void testLineIsSinglePoint() {
        Point p1_1 = new Point(1, 1);
        Point p1_2 = new Point(1, 1);
        assertTrue(TrigUtil.isSinglePoint(new Line(p1_1, p1_2)));

        Point p2 = new Point(2, 2);
        assertFalse(TrigUtil.isSinglePoint(new Line(p1_1, p2)));
    }

    @Test
    void testGetBiggest() {
        assertEquals(Optional.empty(), TrigUtil.getBiggest(Collections.emptyList()));

        Point p1 = new Point(2, 1);
        Point p2 = new Point(3, 2);
        assertEquals(Optional.of(p1), TrigUtil.getBiggest(List.of(p1, p2)));

        Circle c1 = new Circle(p1, 10);
        Circle c2 = new Circle(p1, 20);
        assertEquals(Optional.of(c2), TrigUtil.getBiggest(List.of(c1, c2)));
    }

}
