package dev.tobycook.benchmarks.collections.lists;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
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
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 5, time = 5)
@Measurement(iterations = 5, time = 5)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class ListAddBenchmark {

    /**
     * State holds variables that do not count towards benchmarks
     *
     **/
    @State(Scope.Benchmark)
    public static class ArrayListClass {
        public List<Integer> list;

        @Param({"10", "100", "1000", "10000", "100000"})
        public int elementCount;

        /**
         * Setup and values before benchmark is executed
         */
        @Setup(Level.Invocation)
        public void setup() {
            list = new ArrayList<>();
        }
    }

    @State(Scope.Benchmark)
    public static class LinkedListClass {
        public List<Integer> list;

        @Param({"10", "100", "1000", "10000", "100000"})
        public int elementCount;

        @Setup(Level.Invocation)
        public void setup() {
            list = new LinkedList<>();
        }
    }

    @Benchmark
    public List<Integer> arrayListBenchmark(ArrayListClass arrayList) {
        for (var i = 0; i < arrayList.elementCount; i++) {
            arrayList.list.add(i);
        }
        return arrayList.list;
    }

    @Benchmark
    public List<Integer> linkedListBenchmark(LinkedListClass linkedList) {
        for (var i = 0; i < linkedList.elementCount; i++) {
            linkedList.list.add(i);
        }
        return linkedList.list;
    }

}
