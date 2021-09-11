package dev.tobycook.benchmarks.codehandling;

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
public class UnusedVariablesBenchmark {

    @State(Scope.Benchmark)
    public static class BenchmarkState {
        @Param({"10","100","1000","10000","100000"})
        public int iterations;

        public Double x = Math.random();
        public Double y = Math.random();

    }


    /*
     * Gets removed due to JIT compiler dead code elimination
     */
    @Benchmark
    public void setNullBenchmark(BenchmarkState state, Blackhole bh) {
        Double total = state.x + state.y;
        bh.consume(total);
        total = null;
        bh.consume(total);
    }

    @Benchmark
    public void noSetNullBenchmark(BenchmarkState state, Blackhole bh) {
        Double total = state.x + state.y;
        bh.consume(total);
    }
}
