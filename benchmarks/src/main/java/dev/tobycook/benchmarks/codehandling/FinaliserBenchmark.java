package dev.tobycook.benchmarks.codehandling;

import dev.tobycook.benchmarks.helpers.Person;
import dev.tobycook.benchmarks.helpers.PersonFinaliser;
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


/**
 * Benchmark has strange behaviour. Timing increases exponentially when running
 * personFinaliserBenchmark(), causing java.lang.OutOfMemoryError
 */

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 5, time = 5)
@Measurement(iterations = 10, time = 5)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class FinaliserBenchmark {

    static final int AGE = 18;

    Person personNoFinaliser() {
        return new Person(AGE);
    }

    PersonFinaliser personFinaliser() {
        return new PersonFinaliser(AGE);
    }

    @Benchmark
    public void personBenchmark(Blackhole bh) {
        bh.consume(personNoFinaliser());
    }

    @Benchmark
    public void personFinaliserBenchmark(Blackhole bh) {
        bh.consume(personFinaliser());
    }
}
