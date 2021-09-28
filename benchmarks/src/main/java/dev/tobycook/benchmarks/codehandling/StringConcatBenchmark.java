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

import java.util.concurrent.TimeUnit;


/**
 * This benchmark measures the throughput of appending a string in a loop
 * using concatenation vs StringBuilder.append().
 *
 * @author Toby Cook
 *
 */
@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 5, time = 5)
@Measurement(iterations = 10, time = 5)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class StringConcatBenchmark {

    final String stringValue = "Hello, world!";

    @Param({"1000","10000","100000"})
    public int iterations;

    @Benchmark
    public String stringConcatenationBenchmark() {
        String temp = "";
        for (int i = 0; i < iterations; i++) {
            temp += stringValue;
        }
        return temp;
    }

    @Benchmark
    public String stringBuilderBenchmark() {
        var builder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            builder.append(stringValue);
        }
        return builder.toString();
    }

    @Benchmark
    public String stringBuilderCapacityBenchmark() {
        var builder = new StringBuilder(stringValue.length() * iterations);
        for (int i = 0; i < iterations; i++) {
            builder.append(stringValue);
        }
        return builder.toString();
    }
}
