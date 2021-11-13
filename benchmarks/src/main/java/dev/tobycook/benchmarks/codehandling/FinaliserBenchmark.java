package dev.tobycook.benchmarks.codehandling;

import dev.tobycook.benchmarks.helpers.BaseBenchmark;
import dev.tobycook.benchmarks.helpers.Person;
import dev.tobycook.benchmarks.helpers.PersonFinaliser;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;


/**
 * Benchmark has strange behaviour. Timing increases exponentially when running
 * personFinaliserBenchmark(), causing java.lang.OutOfMemoryError
 */

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class FinaliserBenchmark extends BaseBenchmark {

    private int AGE = 18;

    @TearDown(Level.Iteration)
    public void teardown() {
        System.gc();
    }

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
