package dev.tobycook.benchmarks.datatypes;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 5, time = 5)
@Measurement(iterations = 10, time = 5)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class AutoboxingUnboxingBenchmark {

    public int[] primitivesArr;
    public List<Integer> boxedPrimitivesList;

    public int[] emptyPrimitivesArr;
    public List<Integer> emptyBoxedPrimitivesList;

    @Param({"1000","100000","1000000"})
    public int iterations;

    static final int UNBOXED_INT = 123;
    static final Integer BOXED_INT = 123;

    @Setup(Level.Invocation)
    public void setup() {
        primitivesArr = new int[iterations];
        boxedPrimitivesList = new ArrayList<>();

        emptyPrimitivesArr = new int[iterations];
        emptyBoxedPrimitivesList = new ArrayList<>();

        for (int i = 0; i < iterations; i++) {
            primitivesArr[i] = i;
            boxedPrimitivesList.add(i);
        }
    }

    @Benchmark
    public void primitiveIntegerGetBenchmark(Blackhole bh) {
        int value = primitivesArr[iterations/2];
        bh.consume(value);
    }

    @Benchmark
    public void boxedPrimitiveIntegerGetBenchmark(Blackhole bh) {
        int value = boxedPrimitivesList.get(iterations/2);
        bh.consume(value);
    }

    @Benchmark
    public boolean primitiveIntegerAddBenchmark() {
        return emptyBoxedPrimitivesList.add(UNBOXED_INT);
    }

    @Benchmark
    public boolean boxedPrimitiveAddBenchmark() {
        return emptyBoxedPrimitivesList.add(BOXED_INT);
    }


}
