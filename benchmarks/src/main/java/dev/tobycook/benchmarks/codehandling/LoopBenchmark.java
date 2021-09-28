package dev.tobycook.benchmarks.codehandling;

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
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 5, time = 5)
@Measurement(iterations = 10, time = 5)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class LoopBenchmark {

    List<Integer> data;

    @Param({"1000","100000","1000000"})
    public int iterations;

    @Setup(Level.Trial)
    public void setup() {
        data = new ArrayList<>();
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
        var number = new AtomicInteger();
        data.stream().forEach(number::set);
        return number.get();
    }
}
