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

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 5, time = 5)
@Measurement(iterations = 5, time = 5)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class StringConcatBenchmark {

    @State(Scope.Benchmark)
    public static class StringState {

        public String textToAppend;

        @Param({"10","100","1000","10000","100000"})
        public int iterations;

        @Setup(Level.Invocation)
        public void setup() {
            textToAppend = "SillyGoose";
        }
    }

    @Benchmark
    public void stringConcatenationBenchmark(StringState state, Blackhole bh) {
        String temp = "";
        for (var i = 0; i < state.iterations; i++) {
            temp += state.textToAppend;
        }
        bh.consume(temp);
        bh.consume(state);
    }

    @Benchmark
    public void stringBuilderBenchmark(StringState state, Blackhole bh) {
        var builder = new StringBuilder();
        for (var i = 0; i < state.iterations; i++) {
            builder.append(state.textToAppend);
        }
        bh.consume(builder);
        bh.consume(state);
    }

    @Benchmark
    public void stringBuilderCapacityBenchmark(StringState state, Blackhole bh) {
        var builder = new StringBuilder(state.textToAppend.length() * state.iterations);
        for (var i = 0; i < state.iterations; i++) {
            builder.append(state.textToAppend);
        }
        bh.consume(builder);
        bh.consume(state);
    }


}
