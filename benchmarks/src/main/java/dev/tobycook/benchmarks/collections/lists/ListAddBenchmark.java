package dev.tobycook.benchmarks.collections.lists;

import dev.tobycook.benchmarks.helpers.BaseBenchmark;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.TearDown;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListAddBenchmark extends BaseBenchmark {

    private int NUMBER = 123;
    private List<Integer> arrayList, linkedList;

    @Setup(Level.Iteration)
    public void setup() {
        arrayList = new ArrayList<>();
        linkedList = new LinkedList<>();
    }

    @TearDown(Level.Iteration)
    public void teardown() {
        System.gc();
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
