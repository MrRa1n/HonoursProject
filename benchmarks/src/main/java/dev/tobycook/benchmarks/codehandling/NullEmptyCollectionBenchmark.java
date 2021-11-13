package dev.tobycook.benchmarks.codehandling;

import dev.tobycook.benchmarks.helpers.BaseBenchmark;
import org.openjdk.jmh.annotations.Benchmark;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class NullEmptyCollectionBenchmark extends BaseBenchmark {

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
