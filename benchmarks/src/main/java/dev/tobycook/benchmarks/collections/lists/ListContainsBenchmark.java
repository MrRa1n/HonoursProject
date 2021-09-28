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

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 5, time = 5)
@Measurement(iterations = 10, time = 5)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class ListContainsBenchmark {

    List<Integer> arrayList, linkedList;

    @Param({"1000","100000","1000000"})
    int elementCount;

    static final int DENOMINATOR = 2;

    @Setup(Level.Trial)
    public void setup() {
        arrayList = new ArrayList<>();
        linkedList = new LinkedList<>();
        for (int i = 0; i < elementCount; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }
    }

    @Benchmark
    public boolean arrayListBenchmark() {
        return arrayList.contains(elementCount/DENOMINATOR);
    }

    @Benchmark
    public boolean linkedListBenchmark() {
        return linkedList.contains(elementCount/DENOMINATOR);
    }
}
