package dev.tobycook.benchmarks.collections.maps;

import dev.tobycook.benchmarks.helpers.BaseBenchmark;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Setup;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapContainsValueBenchmark extends BaseBenchmark {

    private int elementCount = 100_000;
    private int denominator = 2;
    private Map<String, Integer> hashMap, linkedHashMap, treeMap;

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
        return hashMap.containsValue(elementCount/denominator);
    }

    @Benchmark
    public boolean linkedHashMapBenchmark() {
        return linkedHashMap.containsValue(elementCount/denominator);
    }

    @Benchmark
    public boolean treeMapBenchmark() {
        return treeMap.containsValue(elementCount/denominator);
    }
}
