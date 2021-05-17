package dk.nine.academy.modernejava.benchmark;

import java.util.Random;

import org.openjdk.jmh.annotations.Benchmark;

import dk.nine.academy.modernejava.Line;
import dk.nine.academy.modernejava.Point;

/**
 * Kør den med:
 *  
 * <code>mvn clean package && java -jar target/benchmarks.jar -wi 1 -i 1 -f 1</code>
 */
public class LineBenchmark {

	final static int NUM_LINES = 1000000;
	final static int ITERATIONS = 5;

	@Benchmark
	public double benchmark() {
	    var random = new Random(37); // Java 10

	    var lines = new Line[NUM_LINES]; // Java 10
		for (int i = 0; i < NUM_LINES; i++) {
			lines[i] = new Line(
					new Point(random.nextInt(10000), random.nextInt(10000)),
					new Point(random.nextInt(10000), random.nextInt(10000)));
		}

		double sum = 0.0; // Men ikke her -- skal være effectively final
		for (int n = 0; n < ITERATIONS; n++) {
			sum = 0.0D;
			for (int i = 0; i < NUM_LINES; i++) {
				sum += lines[i].getLength();
			}
		}
		return sum;
	}
}
