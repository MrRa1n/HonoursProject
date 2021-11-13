package dev.tobycook.benchmarks.collections.sets;

import dev.tobycook.benchmarks.helpers.BaseBenchmark;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Setup;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetAddBenchmark extends BaseBenchmark {

    private int number = 123;
    private Set<Integer> hashSet, linkedHashSet, treeSet;

    @Setup(Level.Iteration)
    public void setup() {
        hashSet = new HashSet<>();
        linkedHashSet = new LinkedHashSet<>();
        treeSet = new TreeSet<>();
    }

    @Benchmark
    public boolean hashSetBenchmark() {
        return hashSet.add(number);
    }

    @Benchmark
    public boolean linkedHashSetBenchmark() {
         return linkedHashSet.add(number);
    }

    @Benchmark
    public boolean treeSetBenchmark() {
        return treeSet.add(number);
    }
}
