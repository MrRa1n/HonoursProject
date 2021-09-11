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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 5, time = 5)
@Measurement(iterations = 5, time = 5)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class NullEmptyCollectionBenchmark {

    @State(Scope.Benchmark)
    public static class NullEmptyState {
        @Param({"10","100","1000","10000","100000"})
        public int iterations;

        public List<Integer> getNullReturnType() {
            return null;
        }

        public List<Integer> getEmptyCollectionReturnType() {
            return Collections.emptyList();
        }

        public List<Integer> getArrayListInstance() {
            return new ArrayList<>();
        }

        public Optional<List<Integer>> getOptionalList() {
            return Optional.empty();
        }
    }

    @Benchmark
    public List<Integer> nullBenchmark(NullEmptyState state) {
        List<Integer> data = null;
        for (var i = 0; i < state.iterations; i++) {
            data = state.getNullReturnType();
        }
        return data;
    }

    @Benchmark
    public List<Integer> emptyCollectionBenchmark(NullEmptyState state) {
        List<Integer> data = null;
        for (var i = 0; i < state.iterations; i++) {
            data = state.getEmptyCollectionReturnType();
        }
        return data;
    }

    @Benchmark
    public List<Integer> arrayListBenchmark(NullEmptyState state) {
        List<Integer> data = null;
        for (var i = 0; i < state.iterations; i++) {
            data = state.getArrayListInstance();
        }
        return data;
    }

    @Benchmark
    public void optionalBenchmark(NullEmptyState state, Blackhole bh) {
        Optional<List<Integer>> data = Optional.empty();
        for (var i = 0; i < state.iterations; i++) {
            data = state.getOptionalList();
        }
        bh.consume(data);
    }

}
