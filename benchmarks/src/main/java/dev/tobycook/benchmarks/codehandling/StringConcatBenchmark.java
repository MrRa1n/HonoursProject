package dev.tobycook.benchmarks.codehandling;

import dev.tobycook.benchmarks.helpers.BaseBenchmark;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;

import java.util.concurrent.TimeUnit;


/**
 * This benchmark measures the throughput of appending a string in a loop
 * using concatenation vs StringBuilder.append().
 *
 * @author Toby Cook
 *
 */
@OutputTimeUnit(TimeUnit.SECONDS)
public class StringConcatBenchmark extends BaseBenchmark {

    private String stringValue = "Hello, world!";
    private int iterations = 100_000;

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
