package dev.tobycook.benchmarks.collections.sets;

import dev.tobycook.benchmarks.collections.maps.MapContainsKeyBenchmark;
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
public class SetRemoveBenchmark {

    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(MapContainsKeyBenchmark.class.getSimpleName())
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
    public HashSet<Integer> hashSetBenchmark(SetClass setClass) {
        for (int i = 0; i < setClass.elementCount; i++) {
            setClass.hashSet.remove(i);
        }
        return setClass.hashSet;
    }

    @Benchmark
    public LinkedHashSet<Integer> linkedHashSetBenchmark(SetClass setClass) {
        for (int i = 0; i < setClass.elementCount; i++) {
            setClass.linkedHashSet.remove(i);
        }
        return setClass.linkedHashSet;
    }

    @Benchmark
    public TreeSet<Integer> treeSetBenchmark(SetClass setClass) {
        for (int i = 0; i < setClass.elementCount; i++) {
            setClass.treeSet.remove(i);
        }
        return setClass.treeSet;
    }
}
