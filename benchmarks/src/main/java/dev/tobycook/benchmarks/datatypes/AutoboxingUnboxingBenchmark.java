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

@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 5, time = 5)
@Measurement(iterations = 5, time = 5)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class AutoboxingUnboxingBenchmark {

    @State(Scope.Benchmark)
    public static class BoxingState {

        public int[] primitivesArr;
        public List<Integer> boxedPrimitivesList;

        public Integer[] emptyPrimitivesArr;
        public List<Integer> emptyBoxedPrimitivesList;

        @Param({"10","100","1000","10000","100000"})
        public int iterations;

        @Setup(Level.Invocation)
        public void setup() {
            primitivesArr = new int[iterations];
            boxedPrimitivesList = new ArrayList<>();
            for (var i = 0; i < iterations; i++) {
                primitivesArr[i] = i;
                boxedPrimitivesList.add(i);
            }
        }
    }

    @Benchmark
    public void primitiveIntegerGetBenchmark(BoxingState state, Blackhole bh) {
        int value = state.primitivesArr[state.iterations-1];
        bh.consume(value);
    }

    @Benchmark
    public void boxedPrimitiveIntegerGetBenchmark(BoxingState state, Blackhole bh) {
        int value = state.boxedPrimitivesList.get(state.iterations-1);
        bh.consume(value);
    }

    @Benchmark
    public void primitiveIntegerAddBenchmark(BoxingState state, Blackhole bh) {
        state.emptyBoxedPrimitivesList = new ArrayList<>();
        for (var i = 0; i < state.iterations; i++) {
            state.emptyBoxedPrimitivesList.add(i);
        }
        bh.consume(state.emptyBoxedPrimitivesList);
    }

    @Benchmark
    public void boxedPrimitiveAddBenchmark(BoxingState state, Blackhole bh) {
        state.emptyBoxedPrimitivesList = new ArrayList<>();
        for (int i = 0; i < state.iterations; i++) {
            state.emptyBoxedPrimitivesList.add(Integer.valueOf(i));
        }
        bh.consume(state.emptyBoxedPrimitivesList);
    }


}
