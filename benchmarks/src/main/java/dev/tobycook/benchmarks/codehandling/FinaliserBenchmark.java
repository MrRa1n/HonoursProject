package dev.tobycook.benchmarks.codehandling;

import dev.tobycook.benchmarks.helpers.Person;
import dev.tobycook.benchmarks.helpers.PersonFinaliser;
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
public class FinaliserBenchmark {

    @State(Scope.Benchmark)
    public static class FinaliserState {
        @Param({"10","100","1000","10000","100000"})
        public int iterations;
    }

    @Benchmark
    public void personFinaliserBenchmark(FinaliserState state, Blackhole bh) {
        for (var i = 0; i < state.iterations; i++) {
            var person = new PersonFinaliser("Toby", 24);
            String name = person.getName();
            bh.consume(name);
        }
    }

    @Benchmark
    public void personBenchmark(FinaliserState state, Blackhole bh) {
        for (var i = 0; i < state.iterations; i++) {
            var person = new Person("Toby", 24);
            String name = person.getName();
            bh.consume(name);
        }
    }
}
