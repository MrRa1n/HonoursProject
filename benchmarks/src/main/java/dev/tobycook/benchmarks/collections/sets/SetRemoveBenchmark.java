package dev.tobycook.benchmarks.collections.sets;

import dev.tobycook.benchmarks.helpers.BaseBenchmark;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Setup;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetRemoveBenchmark extends BaseBenchmark {

    private Set<Integer> hashSet, linkedHashSet, treeSet;
    private int elementCount = 100_000;
    private int searchElement = 50_000;

    @Setup(Level.Invocation)
    public void setup() {
        hashSet = new HashSet<>();
        linkedHashSet = new LinkedHashSet<>();
        treeSet = new TreeSet<>();

        for (var i = 0; i < elementCount; i++) {
            hashSet.add(i);
            linkedHashSet.add(i);
            treeSet.add(i);
        }
    }

    @Benchmark
    public boolean hashSetBenchmark() {
        return hashSet.remove(searchElement);
    }

    @Benchmark
    public boolean linkedHashSetBenchmark() {
        return linkedHashSet.remove(searchElement);
    }

    @Benchmark
    public boolean treeSetBenchmark() {
        return treeSet.remove(searchElement);
    }
}
