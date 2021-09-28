package dev.tobycook.benchmarks.datatypes;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 5, time = 5)
@Measurement(iterations = 10, time = 5)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class StringObjectLiteralsBenchmark {

    final String stringValue = "Hello, world!";
    byte[] stringBytes;

    @Setup(Level.Trial)
    public void setup() {
        stringBytes = stringValue.getBytes();
    }

    @Benchmark
    public String stringLiteralBenchmark() {
        String value = stringValue;
        return value;
    }

    @Benchmark
    public String stringObjectBenchmark() {
        return new String(stringBytes);
    }
}
