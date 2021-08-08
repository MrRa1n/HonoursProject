package dev.tobycook.benchmarks.codehandling;

public class Finalisers {

    public int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    @Override
    protected void finalize() throws Throwable {

    }
}
