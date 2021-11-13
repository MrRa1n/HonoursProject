package dev.tobycook.benchmarks.datatypes;

import dev.tobycook.benchmarks.helpers.BaseBenchmark;
import org.openjdk.jmh.annotations.Benchmark;

public class StringObjectLiteralsBenchmark extends BaseBenchmark {

    private String stringValue = "Hello, world!";
    private byte[] stringBytes = stringValue.getBytes();

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
