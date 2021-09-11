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
public class MapContainsValueBenchmark {

    @State(Scope.Benchmark)
    public static class MapClass {

        @Param({"9","99","999","9999","99999"})
        public int searchElement;

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

            for (var i = 0; i < elementCount; i++) {
                hashMap.put("key" + i, i);
            }

            for (var i = 0; i < elementCount; i++) {
                linkedHashMap.put("key" + i, i);
            }

            for (var i = 0; i < elementCount; i++) {
                treeMap.put("key" + i, i);
            }
        }
    }

    @Benchmark
    public boolean hashMapBenchmark(MapClass mapClass) {
        return mapClass.hashMap.containsValue(mapClass.searchElement);
    }

    @Benchmark
    public boolean linkedHashMapBenchmark(MapClass mapClass) {
        return mapClass.linkedHashMap.containsValue(mapClass.searchElement);
    }

    @Benchmark
    public boolean treeMapBenchmark(MapClass mapClass) {
        return mapClass.treeMap.containsValue(mapClass.searchElement);
    }
}
