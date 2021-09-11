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

@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 5, time = 5)
@Measurement(iterations = 5, time = 5)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class LoopBenchmark {

    @State(Scope.Benchmark)
    public static class LoopState {
        public List<Integer> data;

        @Param({"10","100","1000","10000","100000"})
        public int iterations;

        @Setup(Level.Invocation)
        public void setup() {
            data = new ArrayList<>();
            for (var i = 0; i < iterations; i++) {
                data.add(i);
            }
        }
    }

    @Benchmark
    public void iteratorBenchmark(LoopState state, Blackhole bh) {
        var iterator = state.data.iterator();
        int number = 0;
        while (iterator.hasNext()) {
            number = iterator.next();
        }
        bh.consume(number);
        bh.consume(iterator);
    }

    @Benchmark
    public void foreachBenchmark(LoopState state, Blackhole bh) {
        int number = 0;
        for (Integer d : state.data) {
            number = d;
        }
        bh.consume(number);
    }

    @Benchmark
    public void forBenchmark(LoopState state, Blackhole bh) {
        int number = 0;
        for (int i = 0; i < state.data.size(); i++) {
            number = state.data.get(i);
        }
        bh.consume(number);
    }

    @Benchmark
    public void streamForBenchmark(LoopState state, Blackhole bh) {
        AtomicInteger number = new AtomicInteger();
        state.data.stream().forEach(number::set);
        bh.consume(number);
    }


}
