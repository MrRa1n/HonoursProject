package dev.tobycook.benchmarks.codehandling;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 5, time = 5)
@Measurement(iterations = 10, time = 5)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class NullEmptyCollectionBenchmark {

    @Benchmark
    public List<Integer> nullBenchmark() {
        return null;
    }

    @Benchmark
    public List<Integer> emptyCollectionBenchmark() {
        return Collections.emptyList();
    }

    @Benchmark
    public List<Integer> arrayListBenchmark() {
        return new ArrayList<>();
    }

    @Benchmark
    public Optional<List<Integer>> optionalBenchmark() {
        return Optional.empty();
    }

}
