package dev.tobycook.benchmarks.datatypes;

import dev.tobycook.benchmarks.helpers.BaseBenchmark;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.List;

public class AutoboxingUnboxingBenchmark extends BaseBenchmark {

    public int[] primitivesArr;
    public List<Integer> boxedPrimitivesList;

    public int[] emptyPrimitivesArr;
    public List<Integer> emptyBoxedPrimitivesList;

    private int iterations = 100_000;

    private int unboxedInt = 123;
    private Integer boxedInt = 123;

    @Setup(Level.Iteration)
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
        return emptyBoxedPrimitivesList.add(unboxedInt);
    }

    @Benchmark
    public boolean boxedPrimitiveAddBenchmark() {
        return emptyBoxedPrimitivesList.add(boxedInt);
    }


}
