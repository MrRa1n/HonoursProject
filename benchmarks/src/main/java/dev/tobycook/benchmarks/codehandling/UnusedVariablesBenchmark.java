package dev.tobycook.benchmarks.codehandling;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 5, time = 5)
@Measurement(iterations = 10, time = 5)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class UnusedVariablesBenchmark {

    Double x = Math.random();
    Double y = Math.random();

    @Benchmark
    public void setNullBenchmark(Blackhole bh) {
        Double total = x + y;
        bh.consume(total);
        total = null;
        bh.consume(total);
    }

    @Benchmark
    public void noSetNullBenchmark(Blackhole bh) {
        Double total = x + y;
        bh.consume(total);
    }
}
