package dev.tobycook.benchmarks.collections.maps;

import dev.tobycook.benchmarks.helpers.BaseBenchmark;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Setup;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapContainsKeyBenchmark extends BaseBenchmark {

    private int elementCount = 100_000;
    private String searchElement = "key50000";
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
