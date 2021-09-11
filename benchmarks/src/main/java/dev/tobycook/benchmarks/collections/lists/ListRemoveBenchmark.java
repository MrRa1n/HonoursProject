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
public class ListRemoveBenchmark {

    @State(Scope.Benchmark)
    public static class ArrayListClass {
        public List<Integer> list;

        @Param({"10", "100", "1000", "10000", "100000"})
        public int elementCount;

        @Setup(Level.Invocation)
        public void setup() {
            list = new ArrayList<>();
            for (var i = 0; i < elementCount; i++) {
                list.add(i);
            }
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
            for (var i = 0; i < elementCount; i++) {
                list.add(i);
            }
        }
    }

    @Benchmark
    public List<Integer> arrayListBenchmark(ArrayListClass arrayList) {
        for (var i = arrayList.list.size() - 1; i > 0; i--) {
            arrayList.list.remove(i);
        }
        return arrayList.list;
    }

    @Benchmark
    public List<Integer> linkedListBenchmark(LinkedListClass linkedList) {
        for (var i = linkedList.list.size() - 1; i > 0; i--) {
            linkedList.list.remove(i);
        }
        return linkedList.list;
    }
}
