package dev.tobycook.benchmarks.collections.sets;

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

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 5, time = 5)
@Measurement(iterations = 10, time = 5)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class SetContainsBenchmark {

    Set<Integer> hashSet, linkedHashSet, treeSet;

    @Param({"1000","100000","1000000"})
    int elementCount;

    int searchElement;

    @Setup(Level.Trial)
    public void setup() {
        hashSet = new HashSet<>();
        linkedHashSet = new LinkedHashSet<>();
        treeSet = new TreeSet<>();
        searchElement = elementCount / 2;

        for (var i = 0; i < elementCount; i++) {
            hashSet.add(i);
            linkedHashSet.add(i);
            treeSet.add(i);
        }
    }


    @Benchmark
    public boolean hashSetBenchmark() {
        return hashSet.contains(searchElement);
    }

    @Benchmark
    public boolean linkedHashSetBenchmark() {
        return linkedHashSet.contains(searchElement);
    }

    @Benchmark
    public boolean treeSetBenchmark() {
        return treeSet.contains(searchElement);
    }
}
