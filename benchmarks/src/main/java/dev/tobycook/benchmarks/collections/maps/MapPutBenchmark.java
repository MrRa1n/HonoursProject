package dev.tobycook.benchmarks.collections.maps;

import dev.tobycook.benchmarks.helpers.BaseBenchmark;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Setup;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class MapPutBenchmark extends BaseBenchmark {

    private Random rnd = new Random();
    private String key;
    private int value = 123456789;
    private Map<String, Integer> hashMap, linkedHashMap, treeMap;

    @Setup(Level.Iteration)
    public void setup() {
        key = "key" + rnd.nextInt(100_000);
        hashMap = new HashMap<>();
        linkedHashMap = new LinkedHashMap<>();
        treeMap = new TreeMap<>();
    }

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
