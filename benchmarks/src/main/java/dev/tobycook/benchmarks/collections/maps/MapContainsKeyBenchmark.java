package dev.tobycook.benchmarks.collections.maps;

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

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 5, time = 5)
@Measurement(iterations = 10, time = 5)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class MapContainsKeyBenchmark {

    @Param({"key500","key50000","key500000"})
    public String searchElement;

    @Param({"1000","100000","1000000"})
    public int elementCount;

    Map<String, Integer> hashMap, linkedHashMap, treeMap;

    @Setup(Level.Trial)
    public void setup() {
        hashMap = new HashMap<>();
        linkedHashMap = new LinkedHashMap<>();
        treeMap = new TreeMap<>();

        for (var i = 0; i < elementCount; i++) {
            hashMap.put("key" + i, i);
            linkedHashMap.put("key" + i, i);
            treeMap.put("key" + i, i);
        }
    }

    @Benchmark
    public boolean hashMapBenchmark() {
        return hashMap.containsKey(searchElement);
    }

    @Benchmark
    public boolean linkedHashMapBenchmark() {
        return linkedHashMap.containsKey(searchElement);
    }

    @Benchmark
    public boolean treeMapBenchmark() {
        return treeMap.containsKey(searchElement);
    }
}
