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
public class MapPutBenchmark {


    @Param({"1000","100000","1000000"})
    public int elementCount;

    Map<String, Integer> hashMap, linkedHashMap, treeMap;

    String key;
    int value;

    @Setup(Level.Invocation)
    public void setup() {
        hashMap = new HashMap<>();
        linkedHashMap = new LinkedHashMap<>();
        treeMap = new TreeMap<>();
        key = "key" + elementCount / 2;
        value = 0;
    }

    // TODO: Add benchmarks with varying loadFactor and initialCapacity

    @Benchmark
    public Integer hashMapBenchmark() {
        return hashMap.put(key, value);
    }

    @Benchmark
    public Integer linkedHashMapBenchmark() {
        return linkedHashMap.put(key, value);
    }

    @Benchmark
    public Integer treeMapBenchmark() {
        return treeMap.put(key, value);
    }
}
