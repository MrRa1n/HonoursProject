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
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 5, time = 5)
@Measurement(iterations = 5, time = 5)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class MapPutBenchmark {

    @State(Scope.Benchmark)
    public static class MapClass {

        @Param({"10", "100", "1000", "10000", "100000"})
        public int elementCount;

        public HashMap<String, Integer> hashMap;
        public LinkedHashMap<String, Integer> linkedHashMap;
        public TreeMap<String, Integer> treeMap;

        @Setup(Level.Invocation)
        public void setup() {
            hashMap = new HashMap<>();
            linkedHashMap = new LinkedHashMap<>();
            treeMap = new TreeMap<>();
        }
    }

    // TODO: Add benchmarks with varying loadFactor and initialCapacity

    @Benchmark
    public HashMap<String, Integer> hashMapBenchmark(MapContainsKeyBenchmark.MapClass mapClass) {
        for (var i = 0; i < mapClass.elementCount; i++) {
            mapClass.hashMap.put("key" + i, i);
        }
        return mapClass.hashMap;
    }

    @Benchmark
    public LinkedHashMap<String, Integer> linkedHashMapBenchmark(MapContainsKeyBenchmark.MapClass mapClass) {
        for (var i = 0; i < mapClass.elementCount; i++) {
            mapClass.linkedHashMap.put("key" + i, i);
        }
        return mapClass.linkedHashMap;
    }

    @Benchmark
    public TreeMap<String, Integer> treeMapBenchmark(MapContainsKeyBenchmark.MapClass mapClass) {
        for (var i = 0; i < mapClass.elementCount; i++) {
            mapClass.treeMap.put("key" + i, i);
        }
        return mapClass.treeMap;
    }
}