package dev.tobycook.benchmarks.datatypes;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 5, time = 5)
@Measurement(iterations = 5, time = 5)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class StringObjectLiteralsBenchmark {

    @State(Scope.Benchmark)
    public static class StringState {
        @Param({"10","100","1000","10000","100000"})
        public int iterations;
    }


    @Benchmark
    public void stringLiteralBenchmark(StringState state, Blackhole bh) {
        for (int i = 0; i < state.iterations; i++) {
            String value = "Napier";
            bh.consume(value);
        }
    }

    @Benchmark
    public void stringObjectBenchmark(StringState state, Blackhole bh) {
        for (int i = 0; i < state.iterations; i++) {
            String value = new String("Napier");
            bh.consume(value);
        }
    }
}
