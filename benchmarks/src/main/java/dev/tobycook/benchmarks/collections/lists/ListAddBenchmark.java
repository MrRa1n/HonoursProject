package dev.tobycook.benchmarks.collections.lists;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * ArrayList vs LinkedList
 *
 * This benchmark looks at the performance difference between the add operation
 * of ArrayList vs LinkedList.
 *
 * @author Toby Cook
 */
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 5, time = 5)
@Measurement(iterations = 10, time = 5)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class ListAddBenchmark {

    /**
     * State holds variables that do not count towards benchmarks
     *
     **/

    static final int NUMBER = 123;

    List<Integer> arrayList, linkedList;

    /**
     * Setup and values before benchmark is executed
     */
    @Setup(Level.Trial)
    public void setup() {
        arrayList = new ArrayList<>();
        linkedList = new LinkedList<>();
    }

    @Benchmark
    public boolean arrayListBenchmark() {
        return arrayList.add(NUMBER);
    }

    @Benchmark
    public boolean linkedListBenchmark() {
        return linkedList.add(NUMBER);
    }

}
