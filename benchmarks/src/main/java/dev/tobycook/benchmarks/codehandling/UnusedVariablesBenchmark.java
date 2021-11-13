package dev.tobycook.benchmarks.codehandling;

import dev.tobycook.benchmarks.helpers.BaseBenchmark;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

public class UnusedVariablesBenchmark extends BaseBenchmark {

    private Double x = Math.random();
    private Double y = Math.random();

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
