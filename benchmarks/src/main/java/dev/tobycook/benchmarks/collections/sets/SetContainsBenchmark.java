package dev.tobycook.benchmarks.collections.sets;

import dev.tobycook.benchmarks.collections.lists.ListAddBenchmark;
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
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 5, time = 5)
@Measurement(iterations = 5, time = 5)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class SetContainsBenchmark {

    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(ListAddBenchmark.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @State(Scope.Benchmark)
    public static class SetClass {
        public HashSet<Integer> hashSet;
        public LinkedHashSet<Integer> linkedHashSet;
        public TreeSet<Integer> treeSet;

        @Param({"9","99","999","9999","99999"})
        public int searchElement;

        @Param({"10", "100", "1000", "10000", "100000"})
        public int elementCount;

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
    }

    @Benchmark
    public boolean hashSetBenchmark(SetClass setClass) {
        return setClass.hashSet.contains(setClass.searchElement);
    }

    @Benchmark
    public boolean linkedHashSetBenchmark(SetClass setClass) {
        return setClass.linkedHashSet.contains(setClass.searchElement);
    }

    @Benchmark
    public boolean treeSetBenchmark(SetClass setClass) {
        return setClass.treeSet.contains(setClass.searchElement);
    }
}
