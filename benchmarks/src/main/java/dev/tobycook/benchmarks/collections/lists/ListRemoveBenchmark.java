package dev.tobycook.benchmarks.collections.lists;

import dev.tobycook.benchmarks.helpers.BaseBenchmark;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Setup;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListRemoveBenchmark extends BaseBenchmark {

    private List<Integer> arrayList, linkedList;
    private int elementCount = 100_000;
    private int denominator = 2;

    @Setup(Level.Invocation)
    public void setup() {
        arrayList = new ArrayList<>();
        linkedList = new LinkedList<>();
        for (int i = 0; i < elementCount; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }
    }

    @Benchmark
    public int arrayListBenchmark() {
        return arrayList.remove(elementCount/denominator);
    }

    @Benchmark
    public int linkedListBenchmark() {
        return linkedList.remove(elementCount/denominator);
    }
}
