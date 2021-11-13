package dev.tobycook.benchmarks.codehandling;

import dev.tobycook.benchmarks.helpers.BaseBenchmark;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;

@BenchmarkMode(Mode.AverageTime)
public class LoopBenchmark extends BaseBenchmark {

    private List<Integer> data;
    private LongAdder sum;
    private int iterations = 100_000;

    @Setup(Level.Trial)
    public void setup() {
        data = new ArrayList<>();
        sum = new LongAdder();
        for (int i = 0; i < iterations; i++) {
            data.add(i);
        }
    }

    @Benchmark
    public int iteratorBenchmark(Blackhole bh) {
        var iterator = data.iterator();
        int number = 0;
        while (iterator.hasNext()) {
            number += iterator.next();
        }
        bh.consume(iterator);
        return number;
    }

    @Benchmark
    public int forEachBenchmark() {
        int number = 0;
        for (Integer d : data) {
            number += d;
        }
        return number;
    }

    @Benchmark
    public int forBenchmark() {
        int number = 0;
        for (int i = 0; i < data.size(); i++) {
            number += data.get(i);
        }
        return number;
    }


    @Benchmark
    public int streamForEachBenchmark() {
        data.stream().forEach(sum::add);
        return sum.intValue();
    }
}
