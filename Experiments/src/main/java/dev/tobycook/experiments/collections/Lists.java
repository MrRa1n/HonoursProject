package dev.tobycook.experiments.collections;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.sql.Array;
import java.util.ArrayList;

public class Lists {

    public static void main(String[] args) throws RunnerException {
        Options opts = new OptionsBuilder()
                .include(Lists.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opts).run();
    }

    @State(Scope.Benchmark)
    public static class BenchmarkState {
        final int initialCapacity = 0;
        final int iterations = 100;
        int count = 0;
    }

    /**
     * 1. ArrayLists
     */
    @Benchmark
    public void measureArrayListAdd(BenchmarkState state, Blackhole bh) {
        ArrayList<Integer> list = new ArrayList<>(state.initialCapacity);

        for (int i = 0; i < state.iterations; i++) {
            list.add(i, 0);
        }

        bh.consume(list);
        state.count++;
    }

    @Benchmark
    public void measureArrayListRemove(BenchmarkState state, Blackhole bh) {
        ArrayList<Integer> list = new ArrayList<>(state.initialCapacity);

        for (int i = 0; i < state.iterations; i++) {
            list.remove(i);
        }

        bh.consume(list);
        state.count++;
    }
}
