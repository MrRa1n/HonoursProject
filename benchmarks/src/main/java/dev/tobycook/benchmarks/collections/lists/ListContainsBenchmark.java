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

@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 5, time = 5)
@Measurement(iterations = 5, time = 5)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class ListContainsBenchmark {

    @State(Scope.Benchmark)
    public static class ArrayListClass {
        public List<Integer> list;

        @Param({"9","99","999","9999","99999"})
        public int searchElement;

        @Param({"10", "100", "1000", "10000", "100000"})
        public int elementCount;

        @Setup(Level.Invocation)
        public void setup() {
            list = new ArrayList<>();
            for (int i = 0; i < elementCount; i++) {
                list.add(i);
            }
        }
    }

    @State(Scope.Benchmark)
    public static class LinkedListClass {
        public List<Integer> list;

        @Param({"9","99","999","9999","99999"})
        public int searchElement;

        @Param({"10", "100", "1000", "10000", "100000"})
        public int elementCount;

        @Setup(Level.Invocation)
        public void setup() {
            list = new LinkedList<>();
            for (int i = 0; i < elementCount; i++) {
                list.add(i);
            }
        }
    }

    @Benchmark
    public boolean arrayListBenchmark(ArrayListClass arrayList) {
        return arrayList.list.contains(arrayList.searchElement);
    }

    @Benchmark
    public boolean linkedListBenchmark(LinkedListClass linkedList) {
        return linkedList.list.contains(linkedList.searchElement);
    }
}
